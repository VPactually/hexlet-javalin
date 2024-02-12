package gg.jte.generated.ondemand.layout;
import org.example.hexlet.model.pages.WelcomePage;
public final class JtewelcomePageGenerated {
	public static final String JTE_NAME = "layout/welcomePage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,8,8,8,8,8,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, WelcomePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h2>Welcome !!!</h2>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		WelcomePage page = (WelcomePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
