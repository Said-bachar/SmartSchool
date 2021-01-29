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
            return "/fxml/LoginAdmin.fxml";
        }
    
  },

LOGINSTUDENT {
		
      @Override
		public String getTitle() {
          return getStringFromResourceBundle("LoginStudent.title");
      }

      @Override
		public String getFxmlFile() {
          return "/fxml/LoginStudent.fxml";
      }
  
},
LOGINPROFESSOR {
	
    @Override
		public String getTitle() {
        return getStringFromResourceBundle("LoginProfessor.title");
    }

    @Override
		public String getFxmlFile() {
        return "/fxml/LoginProfessor.fxml";
    }

},
HOMESTUDENT {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("HomeStudent.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/HomeStudent.fxml";
    }

},
HOMEPROFESSOR {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("HomeProfessor.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/HomeProfessor.fxml";
    }

},
MAINNOTICEADMIN {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("MainNoticeAdmin.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/mainNoticeAdmin.fxml";
    }

},
NOTICEADMIN {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("NoticeAdmin.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/NoticeAdmin.fxml";
    }

},
NOTICESTUDENT {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("NoticeStudent.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/NoticeStudent.fxml";
    }

},
COURSESSTUDENT1 {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("CoursesStudent1.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/CoursesStudent1.fxml";
    }

},
COURSESSTUDENT2 {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("CoursesStudent2.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/CoursesStudent2.fxml";
    }

},
HOMEADMIN {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("HomeAdmin.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/HomeAdmin.fxml";
    }

},
STUDENTDOCUMENTS {
	
    @Override
	public String getTitle() {
        return getStringFromResourceBundle("StudentDocuments.title");
    }

    @Override
	public String getFxmlFile() {
        return "/fxml/StudentDocuments.fxml";
    }

};
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("bundle").getString(key);
    }
    
   

   
}
