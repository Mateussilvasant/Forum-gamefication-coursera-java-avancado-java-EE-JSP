package configuration;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.interfaces.Claim;

import utils.JWTUtil;

@WebFilter(asyncSupported = true,filterName = "filter",urlPatterns = {"/*"}) 
public class FiltradorAcessos implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		if (req != null) {

			String path = req.getContextPath();
			String uri = req.getRequestURI();
			
			if (uri.lastIndexOf("Login") == -1) {

				Cookie[] cookies = req.getCookies();

				Optional<Cookie> cookieToken = Stream.of(cookies).filter(c -> c.getName().equals("authorization"))
						.findFirst();

				if (cookieToken.isPresent()) {

					String token = cookieToken.get().getValue();

					Map<String, Claim> claims = JWTUtil.decodificarToken(token);

					Optional<Entry<String, Claim>> subject = claims.entrySet().stream().filter(e -> {
						return e.getKey().equals("sub");
					}).findFirst();

					if (subject.isPresent()) {
						chain.doFilter(request, response);
					} else {
						((HttpServletResponse) response).sendRedirect(path + "/Login");
					}

				} else {
					((HttpServletResponse) response).sendRedirect(path + "/Login");
				}
			} else {
				chain.doFilter(request, response);
			}

		}

	}

	@Override
	public void destroy() {
	}

}
