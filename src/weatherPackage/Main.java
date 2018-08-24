package weatherPackage;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

import org.json.*;

public class Main {
	
	private static String KEY = "f08aaaa7af29b7bfb1e5ae3294d9fa67";
	private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?APPID="+KEY+"&units=imperial"+"&q=";
    private static String IMG_URL = "http://openweathermap.org/img/w/";
    
    Location loc;
	Weather weather;
	
    
    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }

    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }
    
    public String getWeatherData(String location) {
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + location)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while (  (line = br.readLine()) != null )
                buffer.append(line + "\r\n");

            is.close();
            con.disconnect();
            return buffer.toString();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }

        return null;

    }

    public byte[] getImage(String code) {
        HttpURLConnection con = null ;
        InputStream is = null;
        try {
            con = (HttpURLConnection) ( new URL(IMG_URL + code + ".png")).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ( is.read(buffer) != -1)
                baos.write(buffer);

            return baos.toByteArray();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }

        return null;

    }

    public static void main(String[] args) throws JSONException, IOException {
    	
    	Main mainProgram = new Main();
    	mainProgram.Initialize();
    	String data = mainProgram.getWeatherData("Irvine,CA");
    	mainProgram.Start(data);
    	byte[] res=mainProgram.getImage(mainProgram.weather.currentCondition.getIcon());
    	mainProgram.GetImage(res);
    	
    }
    public void Initialize() {
    	loc = new Location();
    	weather = new Weather(loc);
    	
    }
    public void Start(String data) throws JSONException {
    	
    	JSONObject jObj = new JSONObject(data);
    	
    	JSONObject coordObj = getObject("coord", jObj);
    	loc.setLatitude(getFloat("lat", coordObj));
    	loc.setLongitude(getFloat("lon", coordObj));

    	JSONObject sysObj = getObject("sys", jObj);
    	loc.setCountry(getString("country", sysObj));
    	loc.setSunrise(getInt("sunrise", sysObj));
    	loc.setSunset(getInt("sunset", sysObj));
    	loc.setCity(getString("name", jObj));
    	
    	
    	weather.location = loc;
    	// We get weather info (This is an array)
    	JSONArray jArr = jObj.getJSONArray("weather");

    	// We use only the first value
    	JSONObject JSONWeather = jArr.getJSONObject(0);
    	weather.currentCondition.setWeatherId(getInt("id", JSONWeather));
    	weather.currentCondition.setDescr(getString("description", JSONWeather));
    	weather.currentCondition.setCondition(getString("main", JSONWeather));
    	weather.currentCondition.setIcon(getString("icon", JSONWeather));

    	JSONObject mainObj = getObject("main", jObj);
    	weather.currentCondition.setHumidity(getInt("humidity", mainObj));
    	weather.currentCondition.setPressure(getInt("pressure", mainObj));
    	weather.temperature.setMaxTemp(getFloat("temp_max", mainObj));
    	weather.temperature.setMinTemp(getFloat("temp_min", mainObj));
    	weather.temperature.setTemp(getFloat("temp", mainObj));

    	// Wind
    	JSONObject wObj = getObject("wind", jObj);
    	weather.wind.setSpeed(getFloat("speed", wObj));
    	weather.wind.setDeg(getFloat("deg", wObj));

    	// Clouds
    	JSONObject cObj = getObject("clouds", jObj);
    	weather.clouds.setPerc(getInt("all", cObj));
    	
    	
    	
    	System.out.println(data);
    	
    	System.out.println(weather.temperature.temp);
    }
    public void GetImage(byte[] res) throws IOException {
    	
    	
    	ByteArrayInputStream bis = new ByteArrayInputStream(res);
    	
    	BufferedImage bImage2 = ImageIO.read(bis);
    	
    	ImageIO.write(bImage2, "png", new File("output.png") );
        System.out.println("image created");
    	
    		
    }
}
