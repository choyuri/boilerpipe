package in.rkvsraman.historian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.ArticleSentencesExtractor;
import de.l3s.boilerpipe.extractors.CanolaExtractor;
import de.l3s.boilerpipe.extractors.DefaultExtractor;
import de.l3s.boilerpipe.extractors.LargestContentExtractor;

@SuppressWarnings("serial")
public class BoilerpipeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		long startTime = System.currentTimeMillis();
		String htmlMessage = req.getParameter("content");
		String extractorType = req.getParameter("extractor");
		String contentType = req.getParameter("contenttype");

		resp.setContentType("application/json; charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		JSONObject responseObject = new JSONObject();
		try {
			if (contentType != null)
				responseObject.put("contenttype", contentType);
			else
				responseObject.put("contenttype", "html");
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (htmlMessage != null) {
			try {
				responseObject.put("content", htmlMessage);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (contentType != null && contentType.equals("url")
				&& htmlMessage != null) {

			try {
				URL url = new URL(htmlMessage);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(url.openStream(), "UTF8"));
				StringBuffer sb = new StringBuffer();
				String line = new String();

				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				htmlMessage = sb.toString();
				responseObject.put("urlcontent", htmlMessage);
				reader.close();

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			responseObject.put("time", SimpleDateFormat.getDateTimeInstance()
					.format(new Date()));
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		if (htmlMessage != null && htmlMessage.length() < 2 * 1024 * 1024) {

			try {

				// responseObject.put("originalContent", htmlMessage);
				responseObject.put("contentlength", htmlMessage.length());
				if (extractorType != null)
					responseObject.put("extractor", extractorType);
				else
					responseObject.put("extractor", "default");
				long now = System.currentTimeMillis();
				String result = new String();
				if (extractorType != null && extractorType.equals("article")) {
					result = ArticleExtractor.INSTANCE.getText(htmlMessage);

				} else if (extractorType != null
						&& extractorType.equals("canola")) {
					result = CanolaExtractor.INSTANCE.getText(htmlMessage);

				} else if (extractorType != null
						&& extractorType.equals("sentence")) {
					result = ArticleSentencesExtractor.INSTANCE
							.getText(htmlMessage);

				} else if (extractorType != null
						&& extractorType.equals("largest")) {
					result = LargestContentExtractor.INSTANCE
							.getText(htmlMessage);

				} else {
					result = DefaultExtractor.INSTANCE.getText(htmlMessage);

				}

				responseObject.put("extractedContent", result);
				responseObject.put("resultLength", result.length());
				responseObject.put("timetaken", System.currentTimeMillis()
						- now);
				responseObject.put("code", "200");
				responseObject.put("message", "ok");
			} catch (BoilerpipeProcessingException e) {
				e.printStackTrace();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				responseObject.put("code", "403");
				responseObject.put("originalContent", htmlMessage);
				responseObject.put("contentlength", htmlMessage.length());
				responseObject.put("message", "no content or content too long");
			} catch (JSONException e1) {

				e1.printStackTrace();
			}

		}
		try {
			responseObject.put("totaltime", System.currentTimeMillis()
					- startTime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write(responseObject.toString());
		resp.getWriter().flush();
		resp.getWriter().close();

	}

}
