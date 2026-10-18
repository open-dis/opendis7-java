import java.io.InputStream;
import java.io.IOException;
import java.lang.System.Logger.Level;

import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;

import org.apache.xmlrpc.webserver.XmlRpcServlet;

import org.apache.logging.log4j.Logger;

/**
 * A subclass of XmlRpcServlet that includes logging. This is heavily swiped from
 * the example at http://www.petrovic.org/blog/?p=127. It is essentially just a
 * subclass that adds logging using the log4j framework.
 *
 * @author DMcG
 */
public class XmlRpcServletLogging extends XmlRpcServlet {

    /** Logger object, logged at the info level */
    private static final Logger LOG = LogManager.getLogger(XmlRpcServletLogging.class);

    /** Constructor */
    public XmlRpcServletLogging() {
        LOG.info("{} created", getClass().getName());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
        LOG.info("doGet(): {} {}", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
        LOG.info("doPost(): {} {}", request, response);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        LOG.info("{} started", getClass().getName());
    }

    @Override
    public void destroy() {
        LOG.info("Stopped {}", getClass().getName());
    }

}
