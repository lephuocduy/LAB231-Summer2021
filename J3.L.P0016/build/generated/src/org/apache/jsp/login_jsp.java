package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_var_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_var_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_var_test.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("    <title>LPD</title>\n");
      out.write("    <meta\n");
      out.write("      name=\"viewport\"\n");
      out.write("      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\n");
      out.write("    />\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("      integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    />\n");
      out.write("    <!-- Font As -->\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"\n");
      out.write("    />\n");
      out.write("    <!-- Recaptcha -->\n");
      out.write("    <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>\n");
      out.write("    \n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/login.css\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"login\">\n");
      out.write("      ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("      ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("      <div id=\"logreg-forms\">\n");
      out.write("        <form class=\"form-signin\" action=\"MainController\" method=\"POST\">\n");
      out.write("          <h1 class=\"h3 mb-3 font-weight-normal\" style=\"text-align: center\">\n");
      out.write("            Sign in\n");
      out.write("          </h1>\n");
      out.write("          <div class=\"social-login\">\n");
      out.write("            <a\n");
      out.write("                class=\"btn google-btn social-btn\"\n");
      out.write("                href=\"https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/LPD/LoginGoogleController&response_type=code\n");
      out.write("                               &client_id=206843261145-pn8ugapln7olg5harvt1nhkcs1jtva2n.apps.googleusercontent.com&approval_prompt=force\"\n");
      out.write("            >\n");
      out.write("              <span\n");
      out.write("                ><i class=\"fab fa-google-plus-g\"></i> Sign in with Google+</span\n");
      out.write("              >\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("          <p style=\"text-align: center\">OR</p>\n");
      out.write("          <input\n");
      out.write("            type=\"text\"\n");
      out.write("            name=\"txtEmail\"\n");
      out.write("            class=\"form-control\"\n");
      out.write("            placeholder=\"Email\"\n");
      out.write("            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtEmail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("          />\n");
      out.write("          <div style=\"height: 22px\">\n");
      out.write("            <font color=\"red\" class=\"ml-1\">\n");
      out.write("              ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.emailError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </font>\n");
      out.write("          </div>\n");
      out.write("          <input\n");
      out.write("            type=\"password\"\n");
      out.write("            name=\"txtPassword\"\n");
      out.write("            class=\"form-control\"\n");
      out.write("            placeholder=\"Password\"\n");
      out.write("          />\n");
      out.write("          <div style=\"height: 22px\">\n");
      out.write("            <font color=\"red\" class=\"ml-1\">\n");
      out.write("              ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.passwordError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </font>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"g-recaptcha\" data-sitekey=\"6LcFK38aAAAAACA1W7em5b1GedlWdqFPeqqMyfPG\"></div>\n");
      out.write("          <div style=\"height: 22px\">\n");
      out.write("            <font color=\"red\" class=\"ml-1\">\n");
      out.write("               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.captchaError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </font>\n");
      out.write("          </div>\n");
      out.write("          <button\n");
      out.write("            class=\"btn btn-success btn-block\"\n");
      out.write("            type=\"submit\"\n");
      out.write("            name=\"action\"\n");
      out.write("            value=\"Login\"\n");
      out.write("          >\n");
      out.write("            <i class=\"fas fa-sign-in-alt\"></i> Sign in\n");
      out.write("          </button>\n");
      out.write("          <hr />\n");
      out.write("          <a\n");
      out.write("            class=\"btn btn-primary btn-block text-white\"\n");
      out.write("            type=\"button\"\n");
      out.write("            id=\"btn-signup\"\n");
      out.write("            href=\"createUser.jsp\"\n");
      out.write("          >\n");
      out.write("            Sign up New Account\n");
      out.write("          </a>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Optional JavaScript -->\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("    <script\n");
      out.write("      src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n");
      out.write("      integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    ></script>\n");
      out.write("    <script\n");
      out.write("      src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("      integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    ></script>\n");
      out.write("    <script\n");
      out.write("      src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("      integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    ></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_var_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ERROR != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    _jspx_th_c_if_0.setVar("alert");
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <div\n");
        out.write("          class=\"alert ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.COLOR}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" alert-dismissible fade show\"\n");
        out.write("          role=\"alert\"\n");
        out.write("        >\n");
        out.write("          <strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ERROR}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</strong>\n");
        out.write("          <button\n");
        out.write("            type=\"button\"\n");
        out.write("            class=\"close\"\n");
        out.write("            data-dismiss=\"alert\"\n");
        out.write("            aria-label=\"Close\"\n");
        out.write("          >\n");
        out.write("            <span aria-hidden=\"true\">&times;</span>\n");
        out.write("          </button>\n");
        out.write("        </div>\n");
        out.write("      ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_var_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_var_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!alert}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <div></div>\n");
        out.write("      ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
