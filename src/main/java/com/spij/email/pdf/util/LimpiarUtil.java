/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spij.email.pdf.util;


import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;






public class LimpiarUtil {
        private static final String ESTILO_INICIO_PARRAFO = "<p style=\"font-family: Arial, Verdana !important; font-size: 10pt !important; text-align: center; font-weight: bold\"><span>";
        private static final String ESTILO_FIN_PARRAFO = "</span></p>";
        private static final String FONT_FAMILY_ARIAL="Arial";
        private static final String KEY_SUP3 = "&sup3;";
        private static final String KEY_E_DIERESIS = "&Euml;";
        private static final String KEY_SPACE = "&nbsp;";
        private static final String KEY_COMILLA ="&quot;";
        
        private static final String KEY_PSI_01 ="[psi]";
        private static final String KEY_PSI_02 ="[PSI]";
        
        private static final String KEY_ETH = "&eth;";
        private static final String KEY_ETH_02 = "&Eth;";
        
        private static final String HTML_SUP_BEGIN="<sup>";
        private static final String HTML_SUP_END="</sup>";
        
        private static final String HTML_SUB_BEGIN = "<sub>";
        private static final String HTML_SUB_END = "</sub>";
        
        private static final String TAG_SUB = "sub";
        
        private static final String ATTRIBUTE_STYLE = "style";
        private static final String ATTRIBUTE_CLASS = "class";
        
        private static final String CODE_SIGMAF = "[sigmaf]";
        private static final String CODE_CHI = "[chi]";
        private static final String CODE_ALPHA_LOWER = "[alpha]";
        private static final String CODE_BETA_LOWER = "[beta]";
        private static final String CODE_GAMMA_LOWER = "[gamma]";
        private static final String CODE_EPSILON_LOWER = "[epsilon]";
        private static final String CODE_ZETA_LOWER = "[zeta]";
        private static final String CODE_ETA_LOWER = "[eta]";
        private static final String CODE_THETA_LOWER = "[theta]";
        private static final String CODE_IOTA_LOWER = "[iota]";
        private static final String CODE_KAPPA_LOWER = "[kappa]";
        private static final String CODE_LAMBDA_LOWER = "[lambda]";
        private static final String CODE_SIGMA_LOWER = "[sigma]";
        private static final String CODE_TAU_LOWER = "[tau]";
        private static final String CODE_UPSILON_LOWER = "[upsilon]";
        private static final String CODE_PHI_LOWER = "[phi]";
        private static final String CODE_OMEGA_LOWER = "[omega]";
        private static final String CODE_RHO_LOWER = "[rho]";
        private static final String CODE_DELTA_LOWER = "[delta]";        
        
        
	/**
	 * Limpiar html.
	 *  Fecha: 27/10/2014
	 *
	 * @param html the html
	 * @return the string
	 */

	
	public String limpiarHtmlImportacion(String html) {
		String texto1;



		

		
		texto1 = html.replaceAll(KEY_COMILLA, "");
                
		texto1 = codificarCaracteres(texto1);
                
		texto1 = texto1.replaceAll(KEY_SPACE, " ");

		texto1 = texto1.replaceAll("<o:p>", "");
		texto1 = texto1.replaceAll("</o:p>", "");
		texto1 = texto1.replaceAll(Constantes.ESTILO_BORDER_BLACK,Constantes.ESTILO_BORDER_BLACK_NEW);
		
		return texto1;
	}
        
        private String codificarCaracteres(String html){
                String texto1 = html.replaceAll("“", "&#8220;");
		texto1 = texto1.replaceAll("”", "&#8221;");
		texto1 = texto1.replaceAll("'", "&#39;");
		texto1 = texto1.replaceAll("‘", "&#8216;");
		texto1 = texto1.replaceAll("’", "&#8217;");
		texto1 = texto1.replaceAll("…", "&#8230;");
                        
                
                return texto1;
        }
	
	
	
	public String limpiarFixTidy(String param){
		String norma = param.replaceAll(Constantes.TRES_PUNTOS_ERROR,Constantes.TRES_PUNTOS);
		norma = norma.replaceAll(Constantes.TRES_PUNTOS_ERROR_2,Constantes.TRES_PUNTOS);
		norma = norma.replaceAll(Constantes.ESTILO_BORDER_BLACK,Constantes.ESTILO_BORDER_BLACK_NEW);
		return norma;
	}
	
	public String limpiarXhtml(String param){
	////<w:tab/> //antes de los espacios
        String xhtml = param.replaceAll(Constantes.ESTILO_22,"");
        xhtml = xhtml.replaceAll(Constantes.ESTILO_COLOR_LETRA,"");
        xhtml = xhtml.replaceAll(Constantes.ESTILO_IND,"");
        xhtml = xhtml.replaceAll(Constantes.ESTILO_ALINEACION,Constantes.ESTILO_RPR_INI + Constantes.ESTILO_20 + Constantes.ESTILO_IDIOMA + Constantes.ESTILO_TIPO_LETRA + Constantes.ESTILO_TAMANIO_ESTILO + Constantes.ESTILO_RPR_FIN);
        /**
        xhtml = xhtml.replaceAll(Constantes.ESTILO_ESPACIO_BLANCO,Constantes.ESTILO_ESPACIO_VACIO);		        
        **/
        xhtml = xhtml.replaceAll(Constantes.ESTILO_20, Constantes.ESTILO_20 + Constantes.ESTILO_IDIOMA + Constantes.ESTILO_TIPO_LETRA + Constantes.ESTILO_ESPACIADO + Constantes.ESTILO_TAMANIO_ESTILO );
        /**
        xhtml = xhtml.replaceAll(Constantes.ESTILO_TBL_TOP,Constantes.ESTILO_TBL_TOP_NEW);
        xhtml = xhtml.replaceAll(Constantes.ESTILO_TBL_LEFT,Constantes.ESTILO_TBL_LEFT_NEW);
        xhtml = xhtml.replaceAll(Constantes.ESTILO_TBL_BOTTOM,Constantes.ESTILO_TBL_BOTTOM_NEW);
        xhtml = xhtml.replaceAll(Constantes.ESTILO_TBL_RIGHT,Constantes.ESTILO_TBL_RIGHT_NEW);
        xhtml = xhtml.replaceAll(Constantes.ESTILO_TBL_INSIDEH,Constantes.ESTILO_TBL_INSIDEH_NEW);
        xhtml = xhtml.replaceAll(Constantes.ESTILO_TBL_INSIDEV,Constantes.ESTILO_TBL_INSIDEV_NEW);
        **/ 
        xhtml = xhtml.replaceAll(Constantes.ESTILO_FIN_BORDER_SIZE,Constantes.ESTILO_FIN_BORDER_SIZE_NEW);
        xhtml = xhtml.replaceAll(Constantes.TIME_NEW_ROMAN,Constantes.ARIAL);
        		        
        xhtml = xhtml.replaceAll(Constantes.ESTILO_ESPACIO,Constantes.ESTILO_TAB);
        xhtml = xhtml.replaceAll(Constantes.ESTILO_FIN_TAB, Constantes.ESTILO_FIN_ESPACIO);
        
        xhtml = xhtml.replaceAll(Constantes.ESTILO_ESPACIO_A_VARIOS, Constantes.ESTILO_TAB_SOLO);
        xhtml = xhtml.replaceAll(Constantes.ESTILO_ESPACIO_A, Constantes.ESTILO_ESPACIO_A_NEW);
        
        xhtml = decodificarSimbolos(xhtml);
        
        return xhtml;
	}
	
	public String limpiarEspacioBlanco(String html) {
		String texto1;
		
		
		
		texto1 = html.replaceAll(KEY_COMILLA, "");
		
		// ****** termina implementacion incidencia 5 *******
		return texto1;
	}
	
        public String limpiarHtmlImprimir01(String html) {
            
            String texto1 = html.replaceAll("µ","&micro;");
            texto1 = texto1.replaceAll("¶","&para;");
            texto1 = texto1.replaceAll("·","&middot;");
            texto1 = texto1.replaceAll("¸","&cedil;");
            texto1 = texto1.replaceAll("¹","&sup1;");
            texto1 = texto1.replaceAll("º","&ordm;");
            texto1 = texto1.replaceAll("»","&raquo;");
            texto1 = texto1.replaceAll("¼","&frac14;");
            texto1 = texto1.replaceAll("½","&frac12;");
            texto1 = texto1.replaceAll("¾","&frac34;");
            texto1 = texto1.replaceAll("¿","&iquest;");
            
            return texto1;
        }
        
        public String limpiarHtmlImprimir02(String html){
            String texto1 = html.replaceAll("²","&sup2;");
            texto1 = texto1.replaceAll("±","&plusmn;");
            texto1 = texto1.replaceAll("¯","&hibar;");
            texto1 = texto1.replaceAll("°","&deg;");
            texto1 = texto1.replaceAll("®","&reg;");
            texto1 = texto1.replaceAll("¬","&not;");
            texto1 = texto1.replaceAll("«","&laquo;");
            texto1 = texto1.replaceAll("§","&sect;");
            texto1 = texto1.replaceAll("ª","&ordf;");
            texto1 = texto1.replaceAll("©","&copy;");
            texto1 = texto1.replaceAll("¨","&uml;");
            texto1 = texto1.replaceAll("¦","&brvbar;");
            texto1 = texto1.replaceAll("¥","&yen;");
            texto1 = texto1.replaceAll("¤","&curren;");
            texto1 = texto1.replaceAll("¡","&iexcl;");
            texto1 = texto1.replaceAll("£","&pound;");
            texto1 = texto1.replaceAll("¢","&cent;");
            
            return texto1;
        }
        
        public String limpiarHtmlImprimir03(String html){
            String texto1 = html.replaceAll("Ç","&Ccedil;");
            texto1 = texto1.replaceAll("ç","&ccedil;");
            texto1 = texto1.replaceAll("Æ","&AElig;");
            texto1 = texto1.replaceAll("æ","&aelig;");

            texto1 = texto1.replaceAll("Ø","&Oslash;");
            texto1 = texto1.replaceAll("ø","&oslash;");
            texto1 = texto1.replaceAll("×","&times;");

            texto1 = texto1.replaceAll("Ý","&Yacute;");
            texto1 = texto1.replaceAll("ý","&yacute;");
            texto1 = texto1.replaceAll("Þ","&Thorn;");
            texto1 = texto1.replaceAll("þ","&thorn;");
            texto1 = texto1.replaceAll("ß","&Szlig;");
            texto1 = texto1.replaceAll("ß","&szlig;");
            texto1 = texto1.replaceAll("ÿ","&Yuml;");
            texto1 = texto1.replaceAll("ÿ","&yuml;");
            
            return texto1;
        }
        public String limpiarHtmlImprimir05(String html){
            String texto1 = html.replaceAll("> </span>", ">&nbsp;</span>");
            texto1 = texto1.replaceAll("lang=\"ES-PE\"", "");
            texto1 = texto1.replaceAll("Times New Roman", FONT_FAMILY_ARIAL);
            texto1 = texto1.replaceAll("Calibri",FONT_FAMILY_ARIAL);
            
            return texto1;
        }
	public String limpiarHtmlImprimir(String html) {
		String texto1;
		texto1 = html.replaceAll(KEY_COMILLA, "");
                /**
		texto1 = texto1.replaceAll(KEY_SPACE, " ");
		texto1 = texto1.replaceAll(" ", KEY_SPACE);
                **/
		texto1 = limpiarHtmlImprimir05(texto1);
                
                
		texto1 = texto1.replaceAll(">            </span>", ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>");
		texto1 = texto1.replaceAll(">      </span>", ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>");
		
		
		texto1 = texto1.replaceAll("³",KEY_SUP3);
		texto1 = limpiarHtmlImprimir02(texto1);
		
		
		
                
                
                
                
                
                
		texto1 = texto1.replaceAll("Ð",KEY_ETH_02);
		texto1 = texto1.replaceAll("ð",KEY_ETH);
		texto1 =limpiarHtmlImprimir03(texto1);
		
		
                
                
                
                texto1 = codificarCaracteres(texto1);
                
		
		return texto1;
	}
	
	public String limpiarHtmlImprimirCalidadHistorico(String html) {
		String texto1;
		
		texto1 = html.replaceAll(KEY_COMILLA, "");


		texto1 = texto1.replaceAll("     ", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		texto1 = limpiarHtmlImprimir05(texto1);
		
		
		texto1 = texto1.replaceAll("³",KEY_SUP3);
		texto1 = limpiarHtmlImprimir02(texto1);
		
		texto1 = limpiarHtmlImprimir01(texto1);
                
		
		texto1 =limpiarHtmlImprimir03(texto1);
		
		
		texto1 = texto1.replaceAll("Ð",KEY_ETH_02);
		texto1 = texto1.replaceAll("ð",KEY_ETH);
		
		
		                
                texto1 = codificarCaracteres(texto1);
                
                
                texto1 = limpiarVocales(texto1);
                
		return texto1;
	}
	
	public String limpiarMigrado(String contenido){
		String texto;		
		texto = contenido.replaceAll("<h1 class=\"Sumilla\" style=\"font-family: Arial, Verdana; font-size: 12pt; text-align: center; font-weight: bold;\">",
        		"<h1 class=\"Sumilla\" style=\"font-family: Arial, Verdana; font-size: 10pt; text-align: center; font-weight: bold;\">");
		texto = texto.replaceAll("<h2 class=\"Norma\">",
        		"<h2 class=\"Norma\" style=\"font-family: Arial, Verdana; font-size: 10pt; text-align: center; font-weight: bold;\">");
		texto = texto.replaceAll("<p>", "<p class=\"MsoNormal\" style=\"font-family: Arial, Verdana; font-size: 10pt; text-align:justify;line-height: normal;\">"
		 		+ "<span style=\"font-family: Arial, Verdana; font-size: 10pt;\">");
		texto = texto.replaceAll("</p>", "</span></p>");
		texto = texto.replaceAll("<br/>", "<span style=\"display: block;\"> </span>");

		return texto;
	}
	

	
	public String agregarSector(String sector){
		String texto;
		
		texto = ESTILO_INICIO_PARRAFO + sector + ESTILO_FIN_PARRAFO + ESTILO_INICIO_PARRAFO + " " + ESTILO_FIN_PARRAFO;
		return texto;
	}
	
	public String agregarFechaPublicacion(String fechaPub){
		String texto;
		
		texto = ESTILO_INICIO_PARRAFO + fechaPub + ESTILO_FIN_PARRAFO;
		return texto;
	}
	
	/* 
	 * 
	 * PRUEBA GENERAR WORD 
	 * 
	 * */
	
	public String limpiarGenerarWordGeneral(String param){
		
		String html = limpiarHtmlWordGeneral(param);		
		html = html.replace(KEY_SPACE, "[Tspace]");
		html = limpiarHtmlImprimir05(html);
		
		html = codificarSimbolos(html);
						
		Document doc = Jsoup.parse(html);		
		List<Node> listaNodosDoc = doc.body().childNodes();
		
		Node n = doc.body();
		buscarHijosGeneral(n);
		
		StringBuilder contenidoFinal = new StringBuilder("");
		
		for (Node node : listaNodosDoc) {
			contenidoFinal.append(node.outerHtml());
		}		
		

				
		return contenidoFinal.toString().replace("[Tspace]", KEY_SPACE);
	}
	
        private void buscarHijosGeneral01(Node nodoHijo){
            Boolean isStyle = Boolean.FALSE;
            Boolean isClass = Boolean.FALSE;
            for(Attribute atributoP : nodoHijo.attributes().asList()){
                    if (ATTRIBUTE_STYLE.equals(atributoP.getKey()) && !isClass){
                            atributoP.setValue(verificarEstilosPGeneral(atributoP.getValue()));
                            isStyle = Boolean.TRUE;
                    }else if (ATTRIBUTE_CLASS.equals(atributoP.getKey()) && "MsoNormal".equals(atributoP.getValue())){
                            isClass = Boolean.TRUE;
                    }
            }		

            if(!isStyle && !isClass){
                    nodoHijo.attr(ATTRIBUTE_STYLE, "font-family: Arial; font-size: 10pt; text-align: justify;");
            }
        }
        
        private void buscarHijosGeneral02(Node nodoHijo){
            String nuevoNodo = "<span style=\"display: block;\">&nbsp;</span>";
            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
            nodoHijo.replaceWith(n);
        }
        
        private void buscarHijosGeneral03(Node nodoHijo){
            StringBuilder estiloFont = new StringBuilder();
            Boolean isFace = Boolean.FALSE;
            Boolean isSize = Boolean.FALSE;
            for(Attribute atributoP : nodoHijo.attributes().asList()){
                    if ("face".equals(atributoP.getKey())){
                            estiloFont.append("face: ").append(atributoP.getValue()).append(";");
                            isFace = true;
                    }else if("size".equals(atributoP.getKey())){
                            estiloFont.append("size: ").append(atributoP.getValue()).append(";");
                            isSize = true;
                    }
            }

            nodoHijo.attr(ATTRIBUTE_STYLE, verificarEstilosFontGeneral(estiloFont.toString()));

            if (isFace){
                    nodoHijo.removeAttr("face");
            }
            if (isSize){
                    nodoHijo.removeAttr("size");
            }
        }
        
        private void buscarHijosGeneral04(Node nodoHijo){
            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
            String nuevoNodo = HTML_SUP_BEGIN + contenidoNodo + HTML_SUP_END;
            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
            nodoHijo.replaceWith(n);
        }
        
        private void buscarHijosGeneral05(Node nodoHijo){
            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
            String nuevoNodo = HTML_SUB_BEGIN + contenidoNodo + HTML_SUB_END;
            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
            nodoHijo.replaceWith(n);
        }
        
        private boolean buscarHijosGeneral06(Node nodoHijo, boolean flag){
            boolean isSubSup = flag;
            for(Attribute atributoP : nodoHijo.attributes().asList()){
                    if (ATTRIBUTE_STYLE.equals(atributoP.getKey()) && atributoP.getValue().contains("top:")){
                            isSubSup = true;
                            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
                            String nuevoNodo = HTML_SUP_BEGIN + contenidoNodo + HTML_SUP_END;
                            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
                            nodoHijo.replaceWith(n);
                    }else if(ATTRIBUTE_STYLE.equals(atributoP.getKey()) && atributoP.getValue().contains("bottom:")){
                            isSubSup = true;
                            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
                            String nuevoNodo = HTML_SUB_BEGIN + contenidoNodo + HTML_SUB_END;
                            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
                            nodoHijo.replaceWith(n);
                    }
            }
            return isSubSup;
        }
        
	private void buscarHijosGeneral(Node nodoPadre){
		for(Node nodoHijo : nodoPadre.childNodes()){
			Boolean isSubSup = false;
			if ("p".equalsIgnoreCase(nodoHijo.nodeName())){
                            buscarHijosGeneral01(nodoHijo);
                            
			}else if("br".equalsIgnoreCase(nodoHijo.nodeName())){
                            buscarHijosGeneral02(nodoHijo);
                            
			}else if("font".equalsIgnoreCase(nodoHijo.nodeName())){
                            buscarHijosGeneral03(nodoHijo);
                            
			}else if("sup".equalsIgnoreCase(nodoHijo.nodeName())){
				isSubSup = true;
                                buscarHijosGeneral04(nodoHijo);
                                
			}else if(TAG_SUB.equalsIgnoreCase(nodoHijo.nodeName())){
                                buscarHijosGeneral05(nodoHijo);
				isSubSup = true;
			}else if("span".equalsIgnoreCase(nodoHijo.nodeName())){
				isSubSup = buscarHijosGeneral06(nodoHijo, isSubSup);
			}
			
			if (nodoHijo.childNodeSize() > 0 && !"table".equals(nodoHijo.nodeName()) && !isSubSup){
				buscarHijosGeneral(nodoHijo);
			}else if("table".equals(nodoHijo.nodeName())){
				buscarHijosTablaGeneral(nodoHijo);
			}
		}
	}
	
        private void buscarHijosTablaGeneral01(Node nodoHijo){
            Boolean isStyle = Boolean.FALSE;
				
            for(Attribute atributoP : nodoHijo.attributes().asList()){
                    if (ATTRIBUTE_STYLE.equals(atributoP.getKey())){
                            isStyle = Boolean.TRUE;
                    }
            }

            if(!isStyle){
                    nodoHijo.attr(ATTRIBUTE_STYLE, "font-family: Arial; font-size: 10pt;");
            }
        }
        
        private void buscarHijosTablaGeneral02(Node nodoHijo){
            String nuevoNodo = "<span><br><span></span></span>";
            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
            nodoHijo.replaceWith(n);
        }
        
        private void buscarHijosTablaGeneral03(Node nodoHijo){
            StringBuilder estiloFont = new StringBuilder();
            Boolean isFace = Boolean.FALSE;
            Boolean isSize = Boolean.FALSE;
            for(Attribute atributoP : nodoHijo.attributes().asList()){
                    if ("face".equals(atributoP.getKey())){
                            estiloFont.append("face: ").append(atributoP.getValue()).append(";");
                            isFace = true;
                    }else if("size".equals(atributoP.getKey())){
                            estiloFont.append("size: ").append(atributoP.getValue()).append(";");
                            isSize = true;
                    }
            }

            nodoHijo.attr(ATTRIBUTE_STYLE, verificarEstilosFontGeneral(estiloFont.toString()));

            if (isFace){
                    nodoHijo.removeAttr("face");
            }
            if (isSize){
                    nodoHijo.removeAttr("size");
            }
        }
        
        private void buscarHijosTablaGeneral04(Node nodoHijo){
            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
            String nuevoNodo = HTML_SUP_BEGIN + contenidoNodo + HTML_SUP_END;
            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
            nodoHijo.replaceWith(n);
        }
        
        private void buscarHijosTablaGeneral05(Node nodoHijo){
            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
            String nuevoNodo = HTML_SUB_BEGIN + contenidoNodo + HTML_SUB_END;
            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
            nodoHijo.replaceWith(n);
        }
        
        private boolean buscarHijosTablaGeneral06(Node nodoHijo, boolean flag){
            boolean isSubSup = flag;
            for(Attribute atributoP : nodoHijo.attributes().asList()){
                    if (ATTRIBUTE_STYLE.equals(atributoP.getKey()) && atributoP.getValue().contains("top:")){
                            isSubSup = true;
                            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
                            String nuevoNodo = HTML_SUP_BEGIN + contenidoNodo + HTML_SUP_END;
                            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
                            nodoHijo.replaceWith(n);
                    }else if(ATTRIBUTE_STYLE.equals(atributoP.getKey()) && atributoP.getValue().contains("bottom:")){
                            isSubSup = true;
                            String contenidoNodo = Jsoup.parse(nodoHijo.outerHtml()).text();
                            String nuevoNodo = HTML_SUB_BEGIN + contenidoNodo + HTML_SUB_END;
                            Node n = Jsoup.parse(nuevoNodo).body().childNode(0);
                            nodoHijo.replaceWith(n);
                    }
            }
            
            return isSubSup;
        }
        
	private void buscarHijosTablaGeneral(Node nodoPadre){
		for(Node nodoHijo : nodoPadre.childNodes()){
			Boolean isSubSup = false;
			if ("p".equalsIgnoreCase(nodoHijo.nodeName())){
                            buscarHijosTablaGeneral01(nodoHijo);
			}else if("br".equalsIgnoreCase(nodoHijo.nodeName())){
                            buscarHijosTablaGeneral02(nodoHijo);				
			}else if("font".equalsIgnoreCase(nodoHijo.nodeName())){
                            buscarHijosTablaGeneral03(nodoHijo);
			}else if("sup".equalsIgnoreCase(nodoHijo.nodeName())){
                            isSubSup = true;
                            buscarHijosTablaGeneral04(nodoHijo);				
			}else if(TAG_SUB.equalsIgnoreCase(nodoHijo.nodeName())){
				isSubSup = true;
                            buscarHijosTablaGeneral05(nodoHijo);		
			}else if("span".equalsIgnoreCase(nodoHijo.nodeName())){
				isSubSup = buscarHijosTablaGeneral06(nodoHijo, isSubSup);
			}
			
			if (nodoHijo.childNodeSize() > 0 && !isSubSup){
				buscarHijosTablaGeneral(nodoHijo);
			}
		}
	}
	
	
	
	private String verificarEstilosPGeneral(String estiloAnterior){
		StringBuilder newStyle = new StringBuilder("");
		String alineacion = "text-align:justify;";
		Boolean isAlign = false;
		String delimitadores = ";";
		String[] estilosSeparados = estiloAnterior.split(delimitadores);
		for (String style : estilosSeparados) {
			if (style.contains("text-align")){
				isAlign = true;
			}else{
				newStyle.append(style).append(";");
			}
		}
		
		if (isAlign){
			newStyle.append(alineacion).append( ";");
		}
		return newStyle.toString();
	}
	
	private String verificarEstilosFontGeneral(String estiloAnterior){
		StringBuilder newStyle = new StringBuilder("");
		String delimitadores = ";";
		Boolean isFace = false;
		Boolean isSize = false;
		String[] estilosSeparados = estiloAnterior.split(delimitadores);
		for (String style : estilosSeparados) {
			if (style.contains("face")){
				newStyle.append(style.replace("face", "font-family")).append(";");
				isFace = true;
			}else if(style.contains("size")){
				newStyle.append(style.replace("size", "font-size").replace("1", "8pt").replace("2", "10pt").replace("3", "11pt")).append(";");
				isSize = true;
			}
		}
		
		if (!isFace){
			newStyle.append("font-family: Arial;");
		}
		if (!isSize){
			newStyle.append("font-size: 10pt");
		}
		
		return newStyle.toString();
	}
        
        public String limpiarVocales(String html){
                String texto1 = html.replaceAll("á","&aacute;");
		texto1 = texto1.replaceAll("é","&eacute;");
		texto1 = texto1.replaceAll("í","&iacute;");
		texto1 = texto1.replaceAll("ó","&oacute;");
		texto1 = texto1.replaceAll("ú","&uacute;");
                
                
		texto1 = texto1.replaceAll("À","&Agrave;");
		texto1 = texto1.replaceAll("à","&agrave;");
		texto1 = texto1.replaceAll("Á","&Aacute;");
		texto1 = texto1.replaceAll("á","&aacute;");
		texto1 = texto1.replaceAll("Â","&Acirc;");
		texto1 = texto1.replaceAll("â","&acirc;");
                texto1 = texto1.replaceAll("Å","&Aring;");
		texto1 = texto1.replaceAll("å","&aring;");
		texto1 = texto1.replaceAll("Ä","&Auml;");
		texto1 = texto1.replaceAll("ä","&auml;");
		texto1 = texto1.replaceAll("Ã","&Atilde;");
		texto1 = texto1.replaceAll("ã","&atilde;");
                
                
                
		texto1 = texto1.replaceAll("Ê","&Ecirc;");
		texto1 = texto1.replaceAll("ê","&ecirc;");
		texto1 = texto1.replaceAll("É","&Eacute;");
		texto1 = texto1.replaceAll("é","&eacute;");
		texto1 = texto1.replaceAll("È","&Egrave;");
		texto1 = texto1.replaceAll("è","&egrave;");
                texto1 = texto1.replaceAll("Ë",KEY_E_DIERESIS);
		texto1 = texto1.replaceAll("ë","&euml;");
                
                                
                
                texto1 = texto1.replaceAll("Ï","&Iuml;");
		texto1 = texto1.replaceAll("ï","&iuml;");
		texto1 = texto1.replaceAll("Î","&Icirc;");
		texto1 = texto1.replaceAll("î","&icirc;");
		texto1 = texto1.replaceAll("Í","&Iacute;");
		texto1 = texto1.replaceAll("í","&iacute;");
		texto1 = texto1.replaceAll("Ì","&Igrave;");
		texto1 = texto1.replaceAll("ì","&igrave;");
                
                
                texto1 = texto1.replaceAll("Ö","&Ouml;");
		texto1 = texto1.replaceAll("ö","&ouml;");
		texto1 = texto1.replaceAll("Õ","&Otilde;");
		texto1 = texto1.replaceAll("õ","&otilde;");
		texto1 = texto1.replaceAll("Ô","&Ocirc;");
		texto1 = texto1.replaceAll("ô","&ocirc;");
		texto1 = texto1.replaceAll("Ó","&Oacute;");
		texto1 = texto1.replaceAll("ó","&oacute;");
		texto1 = texto1.replaceAll("Ò","&Ograve;");
		texto1 = texto1.replaceAll("ò","&ograve;");
                
                
		
		texto1 = texto1.replaceAll("Û","&Ucirc;");
		texto1 = texto1.replaceAll("û","&ucirc;");
		texto1 = texto1.replaceAll("Ü","&Uuml;");
		texto1 = texto1.replaceAll("ü","&uuml;");
                
                texto1 = texto1.replaceAll("Ú","&Uacute;");
		texto1 = texto1.replaceAll("ú","&uacute;");
		texto1 = texto1.replaceAll("Ù","&Ugrave;");
		texto1 = texto1.replaceAll("ù","&ugrave;");
                
                texto1 = texto1.replaceAll("Ñ","&Ntilde;");
		texto1 = texto1.replaceAll("ñ","&ntilde;");
                
                return texto1;
        }
	
	public String limpiarHtmlWordGeneral(String html) {
		String texto1;
		texto1 = html.replaceAll(KEY_COMILLA, "");
		texto1 = texto1.replaceAll(" ", KEY_SPACE);
		texto1 = texto1.replaceAll("lang=\"ES-PE\"", "");

		texto1 = texto1.replaceAll("Times New Roman", FONT_FAMILY_ARIAL);
		
		

		texto1 = texto1.replaceAll("Calibri",FONT_FAMILY_ARIAL);
		
		texto1 = texto1.replaceAll("³",KEY_SUP3);
		texto1 = limpiarHtmlImprimir02(texto1);
		
		texto1 = limpiarHtmlImprimir01(texto1);
                texto1 = limpiarHtmlImprimir03(texto1);
                
                                
		
		
		
		texto1 = texto1.replaceAll("Ñ","&Ntilde;");
		texto1 = texto1.replaceAll("ñ","&ntilde;");
                
                
		texto1 = texto1.replaceAll("Ð",KEY_ETH_02);
		texto1 = texto1.replaceAll("ð",KEY_ETH);
		
						
                
		
                
		


		
                texto1 = codificarCaracteres(texto1);
                
		texto1 = texto1.replace("\r", "SLTR");
		texto1 = texto1.replace("\n", "SLTN");
		texto1 = texto1.replace("\t", "SLTT");
		texto1 = texto1.replace("\f", "SLTF");
		texto1 = texto1.replaceAll("<!--\\[if gte vml 1\\]>(.)*<!\\[endif\\]-->", "");
		texto1 = texto1.replaceAll("<!--\\[if !vml\\]-->(.)*<!--\\[endif\\]-->", "");
		texto1 = texto1.replace("SLTR","\r");
		texto1 = texto1.replace("SLTN","\n");
		texto1 = texto1.replace("SLTT","\t");
		texto1 = texto1.replace("SLTF","\f");
		
                texto1 = limpiarVocales(texto1);
                
		return texto1;
	}
	
	/*
	 * 
	 *  SIMBOLOS
	 * 
	 * 
	 */
	
	public String codificarSimbolos(String html){
		// Minusculas
		String texto = html.replace("&#945;", CODE_ALPHA_LOWER);
		texto = texto.replace("&#946;", CODE_BETA_LOWER);
		texto = texto.replace("&#947;", CODE_GAMMA_LOWER);
		texto = texto.replace("&#948;", CODE_DELTA_LOWER);
		texto = texto.replace("&#949;", CODE_EPSILON_LOWER);
		texto = texto.replace("&#950;", CODE_ZETA_LOWER);
		texto = texto.replace("&#951;", CODE_ETA_LOWER);
		texto = texto.replace("&#952;", CODE_THETA_LOWER);
		texto = texto.replace("&#953;", CODE_IOTA_LOWER);
		texto = texto.replace("&#954;", CODE_KAPPA_LOWER);
		texto = texto.replace("&#955;", CODE_LAMBDA_LOWER);
                texto = texto.replace("&#963;", CODE_SIGMA_LOWER);
		texto = texto.replace("&#964;", CODE_TAU_LOWER);
		texto = texto.replace("&#965;", CODE_UPSILON_LOWER);
		texto = texto.replace("&#966;", CODE_PHI_LOWER);
                texto = texto.replace("&#969;", CODE_OMEGA_LOWER);		
                texto = texto.replace("&#961;", CODE_RHO_LOWER);
                
		texto = texto.replace("&#956;", "[mu]");
		texto = texto.replace("&#957;", "[nu]");
		texto = texto.replace("&#958;", "[xi]");
		texto = texto.replace("&#960;", "[pi]");
		
		texto = texto.replace("&#962;", CODE_SIGMAF);
		
		texto = texto.replace("&#967;", CODE_CHI);
		texto = texto.replace("&#968;", KEY_PSI_01);
		
		
		texto = texto.replace("α", CODE_ALPHA_LOWER);
		texto = texto.replace("β", CODE_BETA_LOWER);
		texto = texto.replace("γ", CODE_GAMMA_LOWER);
		texto = texto.replace("δ", CODE_DELTA_LOWER);
		texto = texto.replace("ε", CODE_EPSILON_LOWER);
		texto = texto.replace("ζ", CODE_ZETA_LOWER);
		texto = texto.replace("η", CODE_ETA_LOWER);
		texto = texto.replace("θ", CODE_THETA_LOWER);
		texto = texto.replace("ι", CODE_IOTA_LOWER);
		texto = texto.replace("κ", CODE_KAPPA_LOWER);
		texto = texto.replace("λ", CODE_LAMBDA_LOWER);
		texto = texto.replace("μ", "[mu]");
		texto = texto.replace("ν", "[nu]");
		texto = texto.replace("ξ", "[xi]");
		texto = texto.replace("π", "[pi]");
		texto = texto.replace("ρ", CODE_RHO_LOWER);
		texto = texto.replace("ς", CODE_SIGMAF);
		texto = texto.replace("σ", CODE_SIGMA_LOWER);
		texto = texto.replace("τ", CODE_TAU_LOWER);
		texto = texto.replace("υ", CODE_UPSILON_LOWER);
		texto = texto.replace("φ", CODE_PHI_LOWER);
		texto = texto.replace("χ", CODE_CHI);
		texto = texto.replace("ψ", KEY_PSI_01);
		texto = texto.replace("ω", CODE_OMEGA_LOWER);
		
		// Mayusculas
		texto = texto.replace("Α", "[ALPHA]");
		texto = texto.replace("Β", "[BETA]");
		texto = texto.replace("Γ", "[GAMMA]");
		texto = texto.replace("Δ", "[DELTA]");
		texto = texto.replace("Ε", "[EPSILON]");
		texto = texto.replace("Ζ", "[ZETA]");
		texto = texto.replace("Η", "[ETA]");
		texto = texto.replace("Θ", "[THETA]");
		texto = texto.replace("Ι", "[IOTA]");
		texto = texto.replace("Κ", "[KAPPA]");
		texto = texto.replace("Λ", "[LAMBDA]");
		texto = texto.replace("Μ", "[MU]");
		texto = texto.replace("Ν", "[NU]");
		texto = texto.replace("Ξ", "[XI]");
		texto = texto.replace("Π", "[PI]");
		texto = texto.replace("Ρ", "[RHO]");
		texto = texto.replace("Σ", "[SIGMA]");
		texto = texto.replace("Τ", "[TAU]");
		texto = texto.replace("Υ", "[UPSILON]");
		texto = texto.replace("Φ", "[PHI]");
		texto = texto.replace("Χ", "[CHI]");
		texto = texto.replace("Ψ", KEY_PSI_02);
		texto = texto.replace("Ω", "[OMEGA]");
		
		// OTROS SIMBOLOS
		texto = texto.replace("“", "[AComillas]");
		texto = texto.replace("”", "[CComillas]");
		
		return texto;
	}
	
	public String decodificarSimbolos(String xhtml){
		// Minusculas
		String texto = xhtml.replace(CODE_ALPHA_LOWER, "&#945;");
		texto = texto.replace(CODE_BETA_LOWER, "&#946;");
		texto = texto.replace(CODE_GAMMA_LOWER, "&#947;");
		texto = texto.replace(CODE_DELTA_LOWER, "&#948;");
		texto = texto.replace(CODE_EPSILON_LOWER, "&#949;");
		texto = texto.replace(CODE_ZETA_LOWER, "&#950;");
		texto = texto.replace(CODE_ETA_LOWER, "&#951;");
		texto = texto.replace(CODE_THETA_LOWER, "&#952;");
		texto = texto.replace(CODE_IOTA_LOWER, "&#953;");
		texto = texto.replace(CODE_KAPPA_LOWER, "&#954;");
		texto = texto.replace(CODE_LAMBDA_LOWER, "&#955;");
		texto = texto.replace("[mu]", "&#956;");
		texto = texto.replace("[nu]", "&#957;");
		texto = texto.replace("[xi]", "&#958;");
		texto = texto.replace("[pi]", "&#960;");
		texto = texto.replace(CODE_RHO_LOWER, "&#961;");
		texto = texto.replace(CODE_SIGMAF, "&#962;");
		texto = texto.replace(CODE_SIGMA_LOWER, "&#963;");
		texto = texto.replace(CODE_TAU_LOWER, "&#964;");
		texto = texto.replace(CODE_UPSILON_LOWER, "&#965;");
		texto = texto.replace(CODE_PHI_LOWER, "&#966;");
		texto = texto.replace(CODE_CHI, "&#967;");
		texto = texto.replace(KEY_PSI_01, "&#968;");
		texto = texto.replace(CODE_OMEGA_LOWER, "&#969;");			
		
		// Mayusculas
		texto = texto.replace("[ALPHA]", "&#913;");
		texto = texto.replace("[BETA]", "&#914;");
		texto = texto.replace("[GAMMA]", "&#915;");	
		texto = texto.replace("[DELTA]", "&#916;");
		texto = texto.replace("[EPSILON]", "&#917;");
		texto = texto.replace("[ZETA]", "&#918;");	
		texto = texto.replace("[ETA]", "&#919;");
		texto = texto.replace("[THETA]", "&#920;");
		texto = texto.replace("[IOTA]", "&#921;");	
		texto = texto.replace("[KAPPA]", "&#922;");
		texto = texto.replace("[LAMBDA]", "&#923;");
		texto = texto.replace("[MU]", "&#924;");	
		texto = texto.replace("[NU]", "&#925;");
		texto = texto.replace("[XI]", "&#926;");
		texto = texto.replace("[PI]", "&#928;");	
		texto = texto.replace("[RHO]", "&#929;");
		texto = texto.replace("[SIGMA]", "&#931;");
		texto = texto.replace("[TAU]", "&#932;");	
		texto = texto.replace("[UPSILON]", "&#933;");
		texto = texto.replace("[PHI]", "&#934;");
		texto = texto.replace("[CHI]", "&#935;");	
		texto = texto.replace(KEY_PSI_02, "&#936;");
		texto = texto.replace("[OMEGA]", "&#937;");
		
		// OTROS SIMBOLOS		
		texto = texto.replace("[AComillas]", "&#8220;");
		texto = texto.replace("[CComillas]", "&#8221;");	
		
		return texto;
	}
		
}

