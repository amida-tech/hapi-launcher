package com.amida.simpleServer;
import java.io.File;
import java.lang.management.ManagementFactory;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AllowSymLinkAliasChecker;
import org.eclipse.jetty.webapp.WebAppContext;



public class App 
{
    public static void main( String[] args )throws Exception{
    	//if there is more than 1 argument the second is the path to use
    	//default is fhis-test
    	String path = "/"+ ((args.length >1)?args[1]:"fhir-test");
    	System.out.println("path "+path);
    	
    	Server server = new Server(8080);
        MBeanContainer mbContainer = new MBeanContainer(
                ManagementFactory.getPlatformMBeanServer());
        server.addBean(mbContainer);
        server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath(path);
        //first argument is which war file to use
        File warFile = new File(args[0]);
       
        webapp.setWar(warFile.getAbsolutePath());
        webapp.addAliasCheck(new AllowSymLinkAliasChecker());
        server.setHandler(webapp);
    	server.start();

    }
}
