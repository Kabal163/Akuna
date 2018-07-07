package com.akuna.security.auth.ajax;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

import com.akuna.security.models.UserContext;
import com.akuna.security.models.token.JwtToken;
import com.akuna.security.models.token.JwtTokenFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 7, 2018
 */

@Component
public class AjaxAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    private final ObjectMapper mapper;
    private final JwtTokenFactory tokenFactory;

    @Autowired
    public AjaxAwareAuthenticationSuccessHandler(ObjectMapper mapper, JwtTokenFactory tokenFactory)
    {
        this.mapper = mapper;
        this.tokenFactory = tokenFactory;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException
    {
        UserContext userContext = (UserContext) authentication.getPrincipal();

        JwtToken accessToken = tokenFactory.createAccessJwtToken(userContext);
        JwtToken refreshToken = tokenFactory.createRefreshJwtToken(userContext);

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", accessToken.getToken());
        tokenMap.put("refreshToken", refreshToken.getToken());

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), tokenMap);

        clearAuthenticationAttributes(request);
    }

    /**
     * Removes temporary authentication-related data which may have been stored
     * in the session during the authentication process..
     *
     */
    protected final void clearAuthenticationAttributes(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);

        if (session == null) return;

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
