package utilitys;

import entilies.LoginEntilies;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;

public class JsonUtility {
    JSONObject jsonObjectForm;

    public JsonUtility() {
        initComponents();
    }

    /**
     * Parse file JSON to data
     */
    public void initComponents() {
        try {
            this.jsonObjectForm = this.parseContent("\\data\\Dataset.json");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public JSONObject parseContent(String dir) throws Exception {
        File file = new File(System.getProperty("user.dir") + dir);
        String content = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(content);
    }

    public LoginEntilies LoginValid() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("1st");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }

    public LoginEntilies Login_Incorrect_Phone() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("2nd");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }

    public LoginEntilies Login_Incorrect_Pass() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("3rd");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }

    public LoginEntilies Login_Invalid_User_Pass() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("4th");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }

    public LoginEntilies Login_Invalid_Format() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("5th");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }

    public LoginEntilies Login_Pwd_lessthan_5() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("6th");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }

    public LoginEntilies Login_Invalid_phone_Pwd_lessthan_5() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("7th");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }

    public LoginEntilies Login_FB() {
        try {
            JSONObject localLogin = jsonObjectForm.getJSONObject("Loginform");
            JSONObject localJsonObject = localLogin.getJSONObject("8th");
            return new LoginEntilies.Builder()
                    .user(localJsonObject.getString("use"))
                    .pwd(localJsonObject.getString("pwd"))
                    .build();
        } catch (Exception e) {
        }
        return null;
    }
}