# Swag_Labs_Testing
This repo is purely for selinium/cucumber practise testing the swag labs sauce demo.
If you wish to fork and use this repo as a base for your own practice you will need to add both the chrome driver and a config.properties file in the test resources folder.

You can download the chromedriver from https://getwebdriver.com/, simply extract the contents and move chromedriver.exe into the test resources folder.

As for the config file you will need to create this yourself in the propeties folder with the name "Config.properties" inside this file you will need the following fields.

login_URL= "Login page URL"

products_URL= "Products page URL"

cart_URL= "Cart page URL"

checkout_step_one_URL= "Step one of the checkout process URL"

checkout_step_two_URL= "Step TWo of the checkout process URL"

checkout_final_step_URL= "The final step of the checkout process URL"

individual_product_Base_URL=https://www.saucedemo.com/v1/inventory-item.html?id=


standard_user= "Standard user username"

locked_out_user= "Locked out user Username"

problem_user= "Problem user username"

performance_glitch_user= "Performance glitch user username"

master_password= "Master password"

These details can be obtained from https://www.saucedemo.com/v1/index.html, I highly suggest exploring the site to get both a feel for site and also the details for the config file.

## Whats been tested

So far tests have been created for the logging in process, adding items to cart and validating that the items have been added to the cart and the complete user journey of making a purchase from log in to checkout with both the standard user and the problem user.

There are 63 total test cases with 48 of them passing, the tests that do not pass have defect reports associated with them. Find these in the defect report folder of the repository.
