package com.verma.rishabh;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        GET get = new GET();
        POST post = new POST();
        TestPost po = new TestPost();
        try{
            JSONArray result = get.GETRequest();
            //System.out.println(result.size());
            //int size = result.size();
            //post.POSTRequest(Integer.toString(size));
            //po.postRequest(Integer.toString(size));

            // Challenge 2
            //int count = get.CountObj(result);
            //po.postRequest(Integer.toString(count));

            // Challenge 3
            //JSONObject main = get.GetActiveProducts(result);
            //po.postRequestChallenge3(main);

            // Challenge 4
            JSONObject main = get.GetActiveProductsPrice(result);
            po.postRequestChallenge3(main);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
