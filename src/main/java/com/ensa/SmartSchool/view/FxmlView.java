package com.ensa.SmartSchool.view;

import java.util.ResourceBundle;


public enum FxmlView {
	
LOGINAS {
		
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("LoginAs.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/LoginAs.fxml";
        }
    
    },
LOGINADMIN {
		
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("LoginAdmin.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Login2.fxml";
        }
    
  };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("bundle").getString(key);
    }
    
   

   
}
