package com.ensa.SmartSchool.documents;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ensa.SmartSchool.entity.Student;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PrintFileGenerator {

    public static JasperPrint generate(Student student, Locale locale,String xmlFile) throws JRException {

        //String xmlFile = "src/main/resources/jasper/invoice_template.jrxml";

        JasperReport jreport = JasperCompileManager.compileReport(xmlFile);

        JRBeanCollectionDataSource beanColDataSource= new JRBeanCollectionDataSource(Collections.singletonList("Invoice"));

        final Map<String, Object> params= parameters(student, locale);

        JasperPrint jrprint = JasperFillManager.fillReport(jreport, params, beanColDataSource);
        
        return jrprint;
    }
    
    private static Map<String, Object> parameters(Student student, Locale locale) {
        final Map<String, Object> parameters = new HashMap<>();
        //parameters.put("logo", getClass().getResourceAsStream(logo_path));
        parameters.put("student",  student);
        parameters.put("REPORT_LOCALE", locale);
        return parameters;
    }
    
    public static JasperPrint generateInternshipCertificate(String xmlPage1, String xmlPage2) throws JRException {
		JasperPrint jp1 = JasperFillManager.fillReport(JasperCompileManager.compileReport(xmlPage1), null,new JREmptyDataSource());
		JasperPrint jp2 = JasperFillManager.fillReport(JasperCompileManager.compileReport(xmlPage2), null, new JREmptyDataSource());
		List<JRPrintPage> pages = jp2.getPages();
		for (int j = 0; j < pages.size(); j++) {
			JRPrintPage object = (JRPrintPage) pages.get(j);
			jp1.addPage(object);
		}
		return jp1;
	}

}