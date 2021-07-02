package in.nareshit.raghu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Student {
	
	@Id
	private Integer sid;
	private String sname;
	private Double sfee;
}
