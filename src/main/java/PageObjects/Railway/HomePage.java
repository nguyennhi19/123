package PageObjects.Railway;

import Common.Constant;

public class HomePage extends GeneralPage {

    public void open() {
        Constant.driver.navigate().to(Constant.RAILWAY_URL);
    }
}
