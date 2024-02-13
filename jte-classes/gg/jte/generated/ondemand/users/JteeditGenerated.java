package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.NamedRoutes;
public final class JteeditGenerated {
	public static final String JTE_NAME = "users/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,5,5,7,7,9,9,10,10,11,11,11,12,12,13,13,15,15,20,20,20,20,20,20,20,20,20,22,22,22,31,31,31,60,60,60,61,61,61,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditUserPage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div align=\"left\">\n        ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n            <ul>\n                ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                    ");
						for (var error : validator) {
							jteOutput.writeContent("\n                        <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                    ");
						}
						jteOutput.writeContent("\n                ");
					}
					jteOutput.writeContent("\n            </ul>\n        ");
				}
				jteOutput.writeContent("\n    </div>\n\n\n<div align=\"left\">\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.userPath(page.getUser().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n        <div>\n            <p>Текущее имя - ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getUser().getName());
				jteOutput.writeContent("</p>\n            <p>\n                Имя\n                <label>\n                    <input type=\"text\" name=\"name\"/>\n                </label>\n            </p>\n        </div>\n        <div>\n            <p>Текущий email - ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("</p>\n            <label>\n                <p>\n                    Email\n                    <input type=\"email\" name=\"email\"/>\n                </p>\n\n            </label>\n        </div>\n        <br>\n        <div>\n            <label>\n                Пароль\n                <input type=\"password\" required name=\"password\"/>\n            </label>\n        </div>\n        <br>\n        <div>\n            <label>\n                Подтверждение пароля\n                <input type=\"password\" required name=\"passwordConfirmation\"/>\n            </label>\n        </div>\n        <br>\n        <input type=\"submit\" value=\"Зарегистрировать\"/>\n    </form>\n</div>\n\n\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditUserPage page = (EditUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
