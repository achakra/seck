package com.pcwerk.seck.rest.restletTest.resources;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.pcwerk.seck.rest.restletTest.SeckWebRestletAppTest;

public class HomeResourceTest extends ServerResource {
	@Get
	public Representation getEntries(Representation entity) {

		if (this.getQuery().isEmpty()
				|| (!this.getQuery().isEmpty() && this.getQuery()
						.getFirstValue("user_input").equals(""))) {
			return toRepresentation(null, "home.jsp", MediaType.TEXT_HTML);

		}		
		JSONObject js0 = new JSONObject();
		JSONArray jsArray = new JSONArray();
		try {
			js0.put("userInput:", this.getQuery().getFirstValue("user_input")
					.toString());
			// js.put("score", 60 + (int) (Math.random() * ((100 - 60) + 1)));
			jsArray.put(js0);
			JSONObject js = new JSONObject();
			for (int i = 1; i < 10; i++) {
				js = new JSONObject();

				js.put("link", "http://resulturl.com/example" + i);
				js.put("score", 60 + (int) (Math.random() * ((100 - 60) + 1)));
				js.put("description",
						"Lorem ipsum dolor sit amet, nam movet libris temporibus et, hinc "
								+ "tota perpetua at nam. Cu eam quaeque insolens signiferumque. Sea sint etiam eu, "
								+ "pro novum ponderum appellantur at. Vel no alterum posidonium, eius salutandi an quo. "
								+ "Vix ei viris docendi, mei ne mucius quidam reprimique. Has porro praesent qualisque "
								+ "an. In his exerci apeirian, vel decore dolorum ullamcorper te.");
				jsArray.put(js);
			}
		} catch (JSONException e) {

			e.printStackTrace();
		}

		return new StringRepresentation(jsArray.toString(), MediaType.APPLICATION_JSON);	
			
		
		
	}

	/*
	 * @Post public Representation postMethod(Representation r) { // Return data
	 * for HTML Freemarker representation
	 * 
	 * 
	 * 
	 * Form form = getRequest().getEntityAsForm();
	 * 
	 * // check whether user insert a value or not if (form.isEmpty() ||(
	 * !form.isEmpty() && form.getFirstValue("user_input").equals(""))) { return
	 * toRepresentation(null, "home.jsp", MediaType.TEXT_HTML);
	 * 
	 * }
	 * 
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * 
	 * JSONObject js0 = new JSONObject(); JSONArray jsArray = new JSONArray();
	 * try { js0.put("userInput:", form.getFirstValue("user_input").toString());
	 * //js.put("score", 60 + (int) (Math.random() * ((100 - 60) + 1)));
	 * jsArray.put(js0); JSONObject js = new JSONObject(); for (int i = 1; i <
	 * 10; i++) { js = new JSONObject();
	 * 
	 * js.put("link", "http://resulturl.com/example" + i); js.put("score", 60 +
	 * (int) (Math.random() * ((100 - 60) + 1))); js.put("description",
	 * "Lorem ipsum dolor sit amet, nam movet libris temporibus et, hinc " +
	 * "tota perpetua at nam. Cu eam quaeque insolens signiferumque. Sea sint etiam eu, "
	 * +
	 * "pro novum ponderum appellantur at. Vel no alterum posidonium, eius salutandi an quo. "
	 * +
	 * "Vix ei viris docendi, mei ne mucius quidam reprimique. Has porro praesent qualisque "
	 * + "an. In his exerci apeirian, vel decore dolorum ullamcorper te.");
	 * jsArray.put(js); } } catch (JSONException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * map.put("jsArray", jsArray);
	 * 
	 * return toRepresentation(map, "results.jsp", MediaType.TEXT_HTML);
	 * 
	 * }
	 */

	public SeckWebRestletAppTest getApplication() {
		return (SeckWebRestletAppTest) super.getApplication();
	}

	private Representation toRepresentation(Map<String, Object> map,
			String templateName, MediaType mediaType) {
		return new TemplateRepresentation(templateName, getApplication()
				.getConfiguration(), map, mediaType);
	}

}
