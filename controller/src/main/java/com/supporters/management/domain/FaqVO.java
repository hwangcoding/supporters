package com.supporters.management.domain;

import com.supporters.function.Paging;

public class FaqVO extends Paging{

	
		private String faq_seq;
		private String faq_title;
		private String faq_content;
		private String faq_write_datetime;
		
		
		
		public String getFaq_seq() {
			return faq_seq;
		}
		public void setFaq_seq(String faq_seq) {
			this.faq_seq = faq_seq;
		}
		public String getFaq_title() {
			return faq_title;
		}
		public void setFaq_title(String faq_title) {
			this.faq_title = faq_title;
		}
		public String getFaq_content() {
			return faq_content;
		}
		public void setFaq_content(String faq_content) {
			this.faq_content = faq_content;
		}
		public String getFaq_write_datetime() {
			return faq_write_datetime;
		}
		public void setFaq_write_datetime(String faq_write_datetime) {
			this.faq_write_datetime = faq_write_datetime;
		}
		
		
	

}
