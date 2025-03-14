package com.gpp_mainappproj.JustMainApp;

public class MyApp 
{
       //System.out.println( "Hello World!" );
        public static void main(String args[]) throws Exception {
            System.out.println("MyApp");
            
            //int count = 10;

            
            //MyApp myMainApplication = new MyApp();
            
            CryptoUtil cryptoUtilObj = new CryptoUtil();
            
            System.out.println("Encrypted SSN returned for 136805132 is--" +cryptoUtilObj.encrypt("136805132"));
            System.out.println("Decrypted SSN returned for GpjiLWrz/jaBgp+kb0yqgA== is--" +cryptoUtilObj.decrypt("GpjiLWrz/jaBgp+kb0yqgA=="));
            System.out.println("Decrypted SSN returned for /ZoUBbHja4uwrM2aDGgS4Q== is--" +cryptoUtilObj.decrypt("/ZoUBbHja4uwrM2aDGgS4Q=="));
            System.out.println();
        }

    
}
