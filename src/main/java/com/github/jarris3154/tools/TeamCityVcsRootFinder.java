package com.github.jarris3154.tools;

import com.github.jarris3154.tools.model.VcsRoots;
import com.github.jarris3154.tools.model.VcsRoot;
import com.github.jarris3154.tools.model.VcsRoot1;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Finder for TeamCity 9.0
 *
 * @author Jarris
 */
public class TeamCityVcsRootFinder {

    public static final  String hostName = "localhost";
    public static final  int    port     = 8111;
    private static final String username = "exampleUsername";
    private static final String password = "examplePassword";

    public static void main(String[] args) throws Exception {

        String uri = "/app/rest/vcs-roots";

        String result = getResponse(uri);

        StringReader reader = new StringReader(result);
        VcsRoots vcsRoots = JAXB.unmarshal(reader, VcsRoots.class);

        List<CompletableFuture<String>> completableFutures = new ArrayList<>();
        for (VcsRoot vcsRoot : vcsRoots.getVcsRoots()) {
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
                    () -> {
                        String href = vcsRoot.getHref();
                    return getResponse(href);
            });

            completableFutures.add(completableFuture);
        }

        for (CompletableFuture<String> future: completableFutures){
            StringReader vcsRootInfoReader = new StringReader(future.get());

            VcsRoot1 vcsRoot1 = JAXB.unmarshal(vcsRootInfoReader, VcsRoot1.class);
            vcsRoot1.getProperties()
                    .getProperties().forEach(property ->
                    {
                        if ("username".equals(property.getName())) {
                            if ("y91686".equals(property.getValue())) {
                                System.out.println(property.getValue() + ": " + vcsRoot1.getId());
                            }
                        }
                    }
            );
        }

        System.out.println("Over...");
    }


    private static String getResponse(String uri) {

        HttpGet request = new HttpGet("http://" + hostName + ":" + port + uri);
        String auth = username + ":" + password;

        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        HttpClient client = HttpClientBuilder.create().build();
        StringBuilder result = new StringBuilder();
        try{
            org.apache.http.HttpResponse response = client.execute(request);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result.toString();
    }
}
