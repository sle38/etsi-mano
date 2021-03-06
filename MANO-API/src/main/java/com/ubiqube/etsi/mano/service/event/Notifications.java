package com.ubiqube.etsi.mano.service.event;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.validation.Valid;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubiqube.etsi.mano.exception.GenericException;
import com.ubiqube.etsi.mano.model.vnf.SubscriptionAuthentication;
import com.ubiqube.etsi.mano.model.vnf.SubscriptionAuthentication.AuthTypeEnum;
import com.ubiqube.etsi.mano.nfvo.v261.model.vnf.SubscriptionAuthenticationParamsBasic;

/**
 * This class handle the notification callback.
 * <li>
 * <ul>
 * Building the HTTP client.
 * </ul>
 * <ul>
 * Crafting the request.
 * </ul>
 * <ul>
 * Sending the request.
 * </ul>
 * <ul>
 * Interpreting the result.
 * </ul>
 * </li> This class should be compatible with Basic, OAuth2, TLS CERT
 * authentification. One the possiblities for OAuth authentification is group:
 * 'net.oauth.core', name: 'oauth-httpclient4', version: '20090913' you may also
 * need this: http://www.codedq.net/blog/articles/146.html
 *
 * @author ovi@ubiqube.com
 *
 */
@Service
public class Notifications {
	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(Notifications.class);
	/** JSON mapper. */
	private final ObjectMapper mapper;

	public Notifications(final ObjectMapper _mapper) {
		mapper = _mapper;
	}

	/**
	 * Send a notification Object to the _uri
	 *
	 * @param obj   The JSON Onject.
	 * @param _uri  The complete URL.
	 * @param _auth Auth parameters.
	 */
	public void doNotification(final Object obj, final String _uri, final SubscriptionAuthentication _auth) {
		String content;
		try {
			content = mapper.writeValueAsString(obj);
		} catch (final JsonProcessingException e) {
			throw new GenericException(e);
		}

		sendRequest(content, _auth, _uri);
	}

	private void sendRequest(final String _content, final SubscriptionAuthentication _auth, final String _uri) {
		HttpClientContext context;
		try {
			context = createContext(_auth, _uri);
		} catch (final MalformedURLException e) {
			throw new GenericException(e);
		}
		final HttpPost httpPost = new HttpPost(_uri);
		httpPost.setHeader("Content-type", "application/json");
		final org.apache.http.entity.StringEntity requestEntity = new StringEntity(_content, ContentType.APPLICATION_JSON);
		httpPost.setEntity(requestEntity);
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			try (CloseableHttpResponse response = httpClient.execute(context.getTargetHost(), httpPost, context)) {
				final int status = response.getStatusLine().getStatusCode();
				if ((status < 200) || (status >= 300)) {
					LOG.error("An error Occured while contacting {} errorcode was: {}", status, _uri);
					throw new GenericException("HttpClient got an error: " + status);
				}
			}
		} catch (final IOException e) {
			throw new GenericException(e);
		}
	}

	private HttpClientContext createContext(final SubscriptionAuthentication _auth, final String _uri) throws MalformedURLException {
		final List<AuthTypeEnum> auths = _auth.getAuthType();
		final URL url = new URL(_uri);
		final HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());

		final HttpClientContext context = auths.stream()
				.map(x -> createContext(x, _auth, targetHost))
				.findFirst()
				.orElse(new HttpClientContext());
		context.setTargetHost(targetHost);
		return context;
	}

	private HttpClientContext createContext(final AuthTypeEnum authType, final SubscriptionAuthentication _auth, final HttpHost targetHost) {
		if (authType == AuthTypeEnum.BASIC) {
			return createBasicContext(_auth.getParamsBasic(), targetHost);
		} else if (authType == AuthTypeEnum.OAUTH2_CLIENT_CREDENTIALS) {
			return createOAuth2Context(_auth.getParamsOauth2ClientCredentials(), targetHost);
		} else if (authType == AuthTypeEnum.TLS_CERT) {
			return createTlsCertContext(targetHost);
		}
		throw new GenericException("Unknown Auth type.");
	}

	private HttpClientContext createTlsCertContext(final HttpHost _targetHost) {
		// http://svn.apache.org/viewvc/httpcomponents/oac.hc3x/trunk/src/contrib/org/apache/commons/httpclient/contrib/ssl/AuthSSLProtocolSocketFactory.java?view=markup
		return new HttpClientContext();
	}

	private HttpClientContext createOAuth2Context(final com.ubiqube.etsi.mano.nfvo.v261.model.vnf.@Valid SubscriptionAuthenticationParamsOauth2ClientCredentials subscriptionAuthenticationParamsOauth2ClientCredentials, final HttpHost _targetHost) {
		return new HttpClientContext();
	}

	private HttpClientContext createBasicContext(final SubscriptionAuthenticationParamsBasic _paramsBasic, final HttpHost _targetHost) {

		final CredentialsProvider credsProvider = new BasicCredentialsProvider();
		final String _username = _paramsBasic.getUserName();
		final String _password = _paramsBasic.getPassword();
		credsProvider.setCredentials(
				new AuthScope(_targetHost.getHostName(), _targetHost.getPort()),
				new UsernamePasswordCredentials(_username, _password));

		// Create AuthCache instance
		final AuthCache authCache = new BasicAuthCache();
		// Generate BASIC scheme object and add it to the local auth cache
		final BasicScheme basicAuth = new BasicScheme();
		authCache.put(_targetHost, basicAuth);

		// Add AuthCache to the execution context
		final HttpClientContext context = HttpClientContext.create();
		context.setCredentialsProvider(credsProvider);
		context.setAuthCache(authCache);
		return context;
	}

}
