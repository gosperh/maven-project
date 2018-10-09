package com.mulesoft.training;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase {

    private static final String CONTENT_TYPE_JSON = "application/json";

	@Test
    public void mavenFlowReturnsHelloMaven() throws Exception {
        runFlowAndExpect("mavenFlow", "Hello Maven");
    }
    
    @Test
    public void retrieveFlightsAddsAppropriateHeader() throws Exception {
    	MuleEvent event = runFlow("retrieveFlights");
    	String contentType = event.getMessage().getOutboundProperty("Content-Type");
    	assertEquals(CONTENT_TYPE_JSON, contentType);
    }
    
    @Override
    protected String getConfigFile() {
        return "maven-project.xml";
    }

}
