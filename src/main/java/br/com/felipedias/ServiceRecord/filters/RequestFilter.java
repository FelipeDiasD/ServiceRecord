package br.com.felipedias.ServiceRecord.filters;


import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.felipedias.ServiceRecord.Repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class RequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        var servletPath = request.getServletPath();



        if( servletPath.startsWith("/records")){

            var authorization = request.getHeader("Authorization");

            var authEncoded = authorization.substring("Basic".length()).trim();

            byte[] authDecoded = Base64.getDecoder().decode(authEncoded);

            var authString = new String(authDecoded);

            String [] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];


            var user = userRepository.findByUsername(username);


            if(user == null){
                response.sendError(401);
            }

            else{

                String bcryptHashString = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());

                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);

                if (passwordVerify.verified){

                    request.setAttribute("userId",user.getId());
                    filterChain.doFilter(request,response);
                }
                else {
                    response.sendError(401);
                }
            }

        }

        else {
            filterChain.doFilter(request,response);
        }
    }
}
