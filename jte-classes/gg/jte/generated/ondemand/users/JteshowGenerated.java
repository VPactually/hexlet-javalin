package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,7,7,7,8,8,8,9,9,9,11,11,11,13,13,13,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"description-from-type-label\">\n        <h2>");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(page.getUser().getId());
				jteOutput.writeContent("</h2>\n        <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getUser().getFirstName());
				jteOutput.writeContent("</p>\n        <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("</p>\n    </div>\n");
			}
		});
		jteOutput.writeContent("\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
