package edu.em.project.main;

import edu.em.project.controller.Controller;

public class Main {

	public static void main(String[] args) {

		Controller ctrl = new Controller();

		String request;
		String response;

//		request = "ADD\nmodel=FUJI\ncolor=green\nprice=999.00\nsize=29";
//		System.out.println(response = ctrl.doAction(request));
//
//		request = "ADD\nmodel=Merida\ncolor=blue\nprice=999.00\nsize=26";
//		System.out.println(response = ctrl.doAction(request));
//
//		request = "ADD\nmodel=Merida\ncolor=blue\nprice=699.00\nsize=26";
//		System.out.println(response = ctrl.doAction(request));
//		
//		request = "ADD\nmodel=Merida\ncolor=green\nprice=599.00\nsize=23";
//		System.out.println(response = ctrl.doAction(request));
//		
//		request = "ADD\nmodel=FUJI\ncolor=white\nprice=999.00\nsize=29";	
//		System.out.println(response = ctrl.doAction(request));
//
//		request = "ADD\nmodel=FUJI\ncolor=blue\nprice=599.00\nsize=23";
//		System.out.println(response = ctrl.doAction(request));
//
//		request = "ADD\nmodel=FUJI\ncolor=blue\nprice=699.00\nsize=29";
//		System.out.println(response = ctrl.doAction(request));
//		
//		request = "ADD\nmodel=Merida\ncolor=green\nprice=899.00\nsize=27";
//		System.out.println(response = ctrl.doAction(request));

		request = "FIND_SIZE\nsize=29";
		response = ctrl.doAction(request);
		System.out.println(response);

		request = "FIND_COLOR\ncolor=blue";
		response = ctrl.doAction(request);
		System.out.println(response);

		request = "FIND_MODEL\nmodel=FUJI";
		response = ctrl.doAction(request);
		System.out.println(response);

		request = "FIND_PRICE\nprice=699";
		response = ctrl.doAction(request);
		System.out.println(response);
		
//		request = "DELETE_MODEL\nmodel=Merida";
//		response = ctrl.doAction(request);
//		System.out.println(response);
		
		
	}

}
