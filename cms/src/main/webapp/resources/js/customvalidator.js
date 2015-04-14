
(function ($, W, D) {
        jQuery.validator.addMethod("hasSpecialCharacters", function (value, element) {
            return this.optional(element) || /^[a-z0-9\_]+$/i.test(value);
        }, "Special Character Cannot be entered");

        jQuery.validator.addMethod("isExist",function(value,element){
        
        	var b=null;
        	$.ajax({
        	type:'post',
        	async:false,
        	url: "isExist",
        	data: 'email='+value,
        	dataType:'json',
        	success:function(data){
        		b=data;
        	}	            
        	});
        	return b;
        },"This email address is already in use");
        
        var cvQuery = {};
        cvQuery.UTIL =
        {
            setupFormValidation: function () {
                $('#registerForm').validate({
                    onkeyup: false,
                    onclick: false,

                    rules: {

                        email: { required: true,
                                 email: true
                        },
                        pwd: { required: true,
                               minlength: 6
                        } ,
                        pwd2: { required: true,
                            	equalTo: '[name=pwd]'
                        },
                        random2: { equalTo: '[name=random1]' }
                        
                    },
                    messages: {
                        	email: { required: "Please enter your email",
                        			email: "Email Address is not valid" 
                        },
                        pwd: { required: "Please enter your password",
                            minlength: "Minimum 6 characters required"
                        },
                        pwd2: { equalTo: "Password does not match" },
                        random2: { equalTo: "Type the correct value appear above" }
                        
                    },
                    submitHandler: function (form) {          
                        $('#span_isExist').empty();
                    	
                    	if(!isExist()){       
                    		$('[name=email]').after("<span id='span_isExit' class='arrow'><label class='error'>This email is already in use</label></span>");
                    		return false;
                    	}                    	
                        form.submit();
                    },
                    errorPlacement: function (label, element) {
                        label.addClass('arrow');
                        label.insertAfter(element);
                    }
                    ,wrapper: 'span'
                });
            }
        };

        $(D).ready(function ($) {
            cvQuery.UTIL.setupFormValidation();
        });

        
        function isExist(){
        	var email=$('[name=email]').val();
        	
        	var b=null;
        	$.ajax({
        	type:'post',
        	async:false,
        	url: "isExist",
        	data: 'email='+email,
        	dataType:'json',
        	success:function(data){
        		b=data;
        	}	            
        	});
        	return b;        	
        }
        
    })(jQuery, window, document);