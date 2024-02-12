package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.model.pages.Page;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,13,13,13,14,14,14,15,15,17,17,36,36,36,56,56,56,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Page page, Content content) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n          integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n    ");
		if (page != null) {
			jteOutput.writeContent("\n        <title>");
			jteOutput.setContext("title", null);
			jteOutput.writeUserContent(page.getHeader());
			jteOutput.writeContent("</title>\n    ");
		} else {
			jteOutput.writeContent("\n        <title>Title for the Site</title>\n    ");
		}
		jteOutput.writeContent("\n</head>\n<body>\n<div class=\"container\">\n    <header class=\"d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom\">\n        <a href=\"/\" class=\"d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none\">\n            <svg class=\"bi me-2\" width=\"40\" height=\"32\">\n                <use xlink:href=\"#broadcast-pin.svg\"></use>\n            </svg>\n            <span class=\"fs-4\">Simple header</span>\n        </a>\n        <ul class=\"nav nav-pills\">\n            <li class=\"nav-item\"><a href=\"/\" class=\"nav-link active\" aria-current=\"page\">Home</a></li>\n            <li class=\"nav-item\"><a href=\"/users\" class=\"nav-link\">Users</a></li>\n            <li class=\"nav-item\"><a href=\"/courses\" class=\"nav-link\">Courses</a></li>\n        </ul>\n    </header>\n</div>\n<div class=\"container\" align=\"center\">\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</div>\n<div class=\"container\">\n    <footer class=\"d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top\">\n        <div class=\"col-md-4 d-flex align-items-center\">\n            <a href=\"/\" class=\"mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1\">\n                <svg class=\"bi\" width=\"30\" height=\"24\">\n                    <use xlink:href=\"#bootstrap\"></use>\n                </svg>\n            </a>\n            <span class=\"text-muted\">© 2024 Company, Inc <a\n                        href=\"https://github.com/VPactually\">Created by VP</a></span>\n        </div>\n    </footer>\n</div>\n<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js\"></script>\n<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Page page = (Page)params.get("page");
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, page, content);
	}
}
