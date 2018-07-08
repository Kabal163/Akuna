package com.akuna.security.auth.jwt;

import io.jsonwebtoken.lang.Assert;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/*
 *
 * @author dmitrii.kanaev
 *
 * Jul 8, 2018
 */

public class SkipPathRequestMatcher implements RequestMatcher
{
    private OrRequestMatcher matchers;
    private RequestMatcher processingMatcher;

    public SkipPathRequestMatcher(List<String> pathToSkip, String processingPath)
    {
        Assert.notNull(pathToSkip);
        List<RequestMatcher> m = pathToSkip.stream().map(AntPathRequestMatcher::new).collect(Collectors.toList());
        matchers = new OrRequestMatcher(m);
        processingMatcher = new AntPathRequestMatcher(processingPath);
    }

    @Override
    public boolean matches(HttpServletRequest request)
    {
        if (matchers.matches(request)) return false;

        return processingMatcher.matches(request);
    }
}
