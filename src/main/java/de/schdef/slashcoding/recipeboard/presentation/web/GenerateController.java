package de.schdef.slashcoding.recipeboard.presentation.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;

import de.schdef.slashcoding.recipeboard.presentation.PdfGenerator;


@Controller
public class GenerateController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(method=RequestMethod.GET, value="/generate.htm")
	public ModelAndView showCredentialForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.info("Returning generate view");

		return new ModelAndView("generate", "now", (new Date()).toString());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/generate.htm")
	public void generatePDF(@RequestParam String username, @RequestParam String password, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DocumentException {

		logger.info("Returning pdf for user '"+username+"'");
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=MeineRezeptzettel.pdf");
		OutputStream out = response.getOutputStream();
		
		ThirdPartyCredential thirdPartyCredential = new ThirdPartyCredential(username, password);
		PdfGenerator generator = new PdfGenerator(thirdPartyCredential);
		generator.generate(out);
		out.flush();    
	}

}