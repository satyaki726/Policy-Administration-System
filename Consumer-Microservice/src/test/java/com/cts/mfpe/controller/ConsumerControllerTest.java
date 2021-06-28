package com.cts.mfpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cts.mfpe.feign.AuthClient;
import com.cts.mfpe.model.ConsumerDetails;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConsumerController.class })
class ConsumerControllerTest {

	@Autowired
	ConsumerController consumerController;
	
	@MockBean
	private AuthClient authClient;
	
	@Test
	public void test() throws Exception {
		
		Mockito.when(authClient.authorizeTheRequest(Mockito.anyString())).thenReturn(true);
		consumerController.viewAllConsumer("1");
		
	}

	public List<ConsumerDetails> getList(){
		ConsumerDetails con = new ConsumerDetails();
		List<ConsumerDetails> list = new ArrayList<>();
		con.setAgentname("Satyaki");
		list.add(con);
		return list;
	}

}
