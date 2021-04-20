package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

  /*  @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }*/

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
        DBUtils.createConnection();
    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconnecting to database...");
        DBUtils.destroy();
    }



}
