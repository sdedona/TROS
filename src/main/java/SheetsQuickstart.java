import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.model.CopySheetToAnotherSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.SheetProperties;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.client.http.HttpTransport;
import java.io.IOException;
import java.security.GeneralSecurityException;




import java.awt.EventQueue;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.*;



public class SheetsQuickstart {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static Sheets sheetsServices;
    private static String spreadsheetId = "1JBX3AtbtB0oarMO-7UdZByhrxyfM_TC4ZxYEe-591gM";
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList("https://www.googleapis.com/auth/spreadsheets");
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential authorize() throws IOException, GeneralSecurityException {
        // Load client secrets.
        InputStream in = SheetsQuickstart.class.getResourceAsStream("/credentials.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), 
            new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver())
            .authorize("user");
        return credential;
    }

    public static Sheets getSheetsServices() throws IOException, GeneralSecurityException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
            JacksonFactory.getDefaultInstance(), credential)
            .setApplicationName(APPLICATION_NAME)
            .build();

    }
    /*public static void change(String name, int col_number, String newVal){
        
    }*/

    public static List<Object> Search(List<List<Object>> everything,String name){
        int index=0;
        for(int i=0;i<everything.size();i++) {
            for(int j=0;j<everything.get(0).size();j++) {
                if(name.equals((String)everything.get(i).get(j))){
                    index=i;
                    break;
                }
            }
        }
        /*
        List<Object> b = values.get(idex);
        b.set(0,"rob");
        values.set(19,b);
        */
        return(everything.get(index));
  
      }


    public static List<Object> search_name(String name, List<List<Object>> names) {
        List<Object> info = new ArrayList<Object>();
        //System.out.println(names);
        int index = 1;
        //System.out.println(names.size());
        boolean check = (String)names.get(11).get(0) == name;
        System.out.println((String)names.get(11).get(0));
        System.out.println(name);
        System.out.println(check);
        for (int i = 1; i<names.size(); i++){
            if (((String)names.get(i).get(0)).equals(name)){
               //System.out.println(i);
               index = i;
           }
        }
        for(int m=0;m<names.get(0).size();m++){
            info.add(names.get(index).get(m));
        }
        
        return info;
    }

    public static void setVals(String name, String header, String newVal) throws IOException, GeneralSecurityException{
        sheetsServices = getSheetsServices();
        ValueRange body = new ValueRange()
            .setValues(Arrays.asList(
                Arrays.asList("Update")
            ));
        UpdateValuesResponse result = sheetsServices.spreadsheets().values()
            .update(spreadsheetId,"A2", body)
            .setValueInputOption("RAW")
            .execute();
    }

    public static void modifycell(String [] a) throws IOException, GeneralSecurityException {
        //[name.col,change]

        //get name row numer
        int row=getNumName(a[0]);

        //idk what this is
        sheetsServices = getSheetsServices();

        //get the list of all the ind
        List<List<Object>> all = getVals();

        //List of the data of that specif person
        //List<Object> temp= SheetsQuickstart.search(name);
        //Print the row,, push the row onto the GUI


        ValueRange body = new ValueRange().setValues(Arrays.asList(Arrays.asList(a[2])));
        //use get range for the Ex."A2"
        UpdateValuesResponse result = sheetsServices.spreadsheets().values().update(spreadsheetId,getRange(a[1],row), body).setValueInputOption("RAW").execute();

    }
    public static String getRange(String col, int row) {
        String a="";
         switch (col) {
             case "0":
                 a="A";
             case "1":
                 a="B";
             case "2":
                 a="C";
             case "3":
                 a="D";
             case "4":
                 a="E";
             case "5":
                 a="F";
             case "6":
                 a="G";
             case "7":
                 a="H";
             case "8":
                 a="I";
             case "9":
                 a="J";
         }
         String b=Integer.toString(row);
         return(a+b);
    }
    public static int getNumName(String name)throws IOException, GeneralSecurityException{
         int index=0;
            List<List<Object>> all = getVals();
            for(int i=1; i<all.size();i++) {
                if(((String)all.get(i).get(0)).equals(name)) {
                    index=i;
                }
            }
            return(index);
        }

    public static List<List<Object>> getVals() throws IOException, GeneralSecurityException{
    	// Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1JBX3AtbtB0oarMO-7UdZByhrxyfM_TC4ZxYEe-591gM";
        final String range = "A1:E";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            //System.out.println("Name, Major");
            int i = 0;
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                //System.out.printf("%s, %s\n", row.get(0), row.get(2));
            	//System.out.println(i);
            	//i++;
            }
            //System.out.println(values);
            //System.out.println("rows "+(values.size()-1));
            //System.out.println("col "+(values.get(0).size()-1));
            //System.out.println("headers: "+values.get(0));
            String [] headers= new String[values.get(0).size()];

            for(i=0; i<values.get(0).size();i++) {
            	headers[i]= (String)values.get(0).get(i);
            }
            for(i=0; i<values.get(0).size();i++) {
            	//System.out.println(headers[i]);
            }
            for(i=0;i<values.size();i++) {
                //System.out.println(values.get(i).get(0));
            }
        
            
        }

        
        return(values);	
    }

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String[] args) throws IOException, GeneralSecurityException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    setVals("Sal", "A!", "HEllo");
					display2 frame = new display2();
					frame.setTitle("TROS");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
       
	}
        
} 