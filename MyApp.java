package com.gpp_mainappproj.JustMainApp;

public class MyApp 
{
        public static void main(String args[]) throws Exception {
            System.out.println("MyApp");                       
            CryptoUtil cryptoUtilObj = new CryptoUtil();
            
            System.out.println("Encrypted SSN returned for 136805132 is--" +cryptoUtilObj.encrypt("136805132"));
            System.out.println("Decrypted SSN returned for GpjiLWrz/jaBgp+kb0yqgA== is--" +cryptoUtilObj.decrypt("GpjiLWrz/jaBgp+kb0yqgA=="));
            System.out.println("Decrypted SSN returned for /ZoUBbHja4uwrM2aDGgS4Q== is--" +cryptoUtilObj.decrypt("/ZoUBbHja4uwrM2aDGgS4Q=="));

        }

    
}
