/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - Employee.as.
 */

package valueObjects
{
import com.adobe.fiber.services.IFiberManagingService;
import com.adobe.fiber.valueobjects.IValueObject;
import flash.events.Event;
import flash.events.EventDispatcher;
import mx.events.PropertyChangeEvent;

import flash.net.registerClassAlias;
import flash.net.getClassByAlias;
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.valueobjects.IPropertyIterator;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

use namespace model_internal;

[ExcludeClass]
public class _Super_Employee extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void 
    {
        try 
        {
            if (flash.net.getClassByAlias("services.Employee") == null)
            {
                flash.net.registerClassAlias("services.Employee", cz);
            } 
        }
        catch (e:Error) 
        {
            flash.net.registerClassAlias("services.Employee", cz); 
        }
    }   
     
    model_internal static function initRemoteClassAliasAllRelated() : void 
    {
    }

	model_internal var _dminternal_model : _EmployeeEntityMetadata;

	/**
	 * properties
	 */
	private var _internal_office : String;
	private var _internal_departmentid : int;
	private var _internal_zipcode : String;
	private var _internal_street : String;
	private var _internal_state : String;
	private var _internal_lastname : String;
	private var _internal_firstname : String;
	private var _internal_photofile : String;
	private var _internal_city : String;
	private var _internal_id : int;
	private var _internal_title : String;
	private var _internal_email : String;
	private var _internal_officephone : String;
	private var _internal_cellphone : String;

    private static var emptyArray:Array = new Array();

    /**
     * derived property cache initialization
     */  
    model_internal var _cacheInitialized_isValid:Boolean = false;   
    
	model_internal var _changeWatcherArray:Array = new Array();   

	public function _Super_Employee() 
	{	
		_model = new _EmployeeEntityMetadata(this);
	
		// Bind to own data properties for cache invalidation triggering  
       
	}

    /**
     * data property getters
     */
	[Bindable(event="propertyChange")] 
    public function get office() : String    
    {
            return _internal_office;
    }    
	[Bindable(event="propertyChange")] 
    public function get departmentid() : int    
    {
            return _internal_departmentid;
    }    
	[Bindable(event="propertyChange")] 
    public function get zipcode() : String    
    {
            return _internal_zipcode;
    }    
	[Bindable(event="propertyChange")] 
    public function get street() : String    
    {
            return _internal_street;
    }    
	[Bindable(event="propertyChange")] 
    public function get state() : String    
    {
            return _internal_state;
    }    
	[Bindable(event="propertyChange")] 
    public function get lastname() : String    
    {
            return _internal_lastname;
    }    
	[Bindable(event="propertyChange")] 
    public function get firstname() : String    
    {
            return _internal_firstname;
    }    
	[Bindable(event="propertyChange")] 
    public function get photofile() : String    
    {
            return _internal_photofile;
    }    
	[Bindable(event="propertyChange")] 
    public function get city() : String    
    {
            return _internal_city;
    }    
	[Bindable(event="propertyChange")] 
    public function get id() : int    
    {
            return _internal_id;
    }    
	[Bindable(event="propertyChange")] 
    public function get title() : String    
    {
            return _internal_title;
    }    
	[Bindable(event="propertyChange")] 
    public function get email() : String    
    {
            return _internal_email;
    }    
	[Bindable(event="propertyChange")] 
    public function get officephone() : String    
    {
            return _internal_officephone;
    }    
	[Bindable(event="propertyChange")] 
    public function get cellphone() : String    
    {
            return _internal_cellphone;
    }    

    /**
     * data property setters
     */      
    public function set office(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_office == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_office;               
        if (oldValue !== value)
        {
            _internal_office = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "office", oldValue, _internal_office));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set departmentid(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_departmentid;               
        if (oldValue !== value)
        {
            _internal_departmentid = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "departmentid", oldValue, _internal_departmentid));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set zipcode(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_zipcode == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_zipcode;               
        if (oldValue !== value)
        {
            _internal_zipcode = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "zipcode", oldValue, _internal_zipcode));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set street(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_street == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_street;               
        if (oldValue !== value)
        {
            _internal_street = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "street", oldValue, _internal_street));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set state(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_state == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_state;               
        if (oldValue !== value)
        {
            _internal_state = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "state", oldValue, _internal_state));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set lastname(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_lastname == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_lastname;               
        if (oldValue !== value)
        {
            _internal_lastname = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "lastname", oldValue, _internal_lastname));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set firstname(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_firstname == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_firstname;               
        if (oldValue !== value)
        {
            _internal_firstname = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "firstname", oldValue, _internal_firstname));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set photofile(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_photofile == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_photofile;               
        if (oldValue !== value)
        {
            _internal_photofile = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "photofile", oldValue, _internal_photofile));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set city(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_city == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_city;               
        if (oldValue !== value)
        {
            _internal_city = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "city", oldValue, _internal_city));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set id(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_id;               
        if (oldValue !== value)
        {
            _internal_id = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "id", oldValue, _internal_id));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set title(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_title == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_title;               
        if (oldValue !== value)
        {
            _internal_title = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "title", oldValue, _internal_title));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set email(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_email == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_email;               
        if (oldValue !== value)
        {
            _internal_email = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "email", oldValue, _internal_email));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set officephone(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_officephone == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_officephone;               
        if (oldValue !== value)
        {
            _internal_officephone = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "officephone", oldValue, _internal_officephone));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set cellphone(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_cellphone == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_cellphone;               
        if (oldValue !== value)
        {
            _internal_cellphone = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "cellphone", oldValue, _internal_cellphone));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    

    /**
     * data property setter listeners
     */   

   model_internal function setterListenerAnyConstraint(value:flash.events.Event):void
   {
        if (model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }        
   }   

    /**
     * valid related derived properties
     */
    model_internal var _isValid : Boolean;
    model_internal var _invalidConstraints:Array = new Array();
    model_internal var _validationFailureMessages:Array = new Array();

    /**
     * derived property calculators
     */

    /**
     * isValid calculator
     */
    model_internal function calculateIsValid():Boolean
    {
        var violatedConsts:Array = new Array();    
        var validationFailureMessages:Array = new Array();    

		if (_model.isOfficeAvailable && _internal_office == null)
		{
			violatedConsts.push("officeIsRequired");
			validationFailureMessages.push("office is required");
		}
		if (_model.isZipcodeAvailable && _internal_zipcode == null)
		{
			violatedConsts.push("zipcodeIsRequired");
			validationFailureMessages.push("zipcode is required");
		}
		if (_model.isStreetAvailable && _internal_street == null)
		{
			violatedConsts.push("streetIsRequired");
			validationFailureMessages.push("street is required");
		}
		if (_model.isStateAvailable && _internal_state == null)
		{
			violatedConsts.push("stateIsRequired");
			validationFailureMessages.push("state is required");
		}
		if (_model.isLastnameAvailable && _internal_lastname == null)
		{
			violatedConsts.push("lastnameIsRequired");
			validationFailureMessages.push("lastname is required");
		}
		if (_model.isFirstnameAvailable && _internal_firstname == null)
		{
			violatedConsts.push("firstnameIsRequired");
			validationFailureMessages.push("firstname is required");
		}
		if (_model.isPhotofileAvailable && _internal_photofile == null)
		{
			violatedConsts.push("photofileIsRequired");
			validationFailureMessages.push("photofile is required");
		}
		if (_model.isCityAvailable && _internal_city == null)
		{
			violatedConsts.push("cityIsRequired");
			validationFailureMessages.push("city is required");
		}
		if (_model.isTitleAvailable && _internal_title == null)
		{
			violatedConsts.push("titleIsRequired");
			validationFailureMessages.push("title is required");
		}
		if (_model.isEmailAvailable && _internal_email == null)
		{
			violatedConsts.push("emailIsRequired");
			validationFailureMessages.push("email is required");
		}
		if (_model.isOfficephoneAvailable && _internal_officephone == null)
		{
			violatedConsts.push("officephoneIsRequired");
			validationFailureMessages.push("officephone is required");
		}
		if (_model.isCellphoneAvailable && _internal_cellphone == null)
		{
			violatedConsts.push("cellphoneIsRequired");
			validationFailureMessages.push("cellphone is required");
		}

		var styleValidity:Boolean = true;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
        model_internal::_cacheInitialized_isValid = true;
        model_internal::invalidConstraints_der = violatedConsts;
        model_internal::validationFailureMessages_der = validationFailureMessages;
        return violatedConsts.length == 0 && styleValidity;
    }  

    /**
     * derived property setters
     */

    model_internal function set isValid_der(value:Boolean) : void
    {
       	var oldValue:Boolean = model_internal::_isValid;               
        if (oldValue !== value)
        {
        	model_internal::_isValid = value;
        	_model.model_internal::fireChangeEvent("isValid", oldValue, model_internal::_isValid);
        }        
    }

    /**
     * derived property getters
     */

    [Transient] 
	[Bindable(event="propertyChange")] 
    public function get _model() : _EmployeeEntityMetadata
    {
		return model_internal::_dminternal_model;              
    }	
    
    public function set _model(value : _EmployeeEntityMetadata) : void       
    {
    	var oldValue : _EmployeeEntityMetadata = model_internal::_dminternal_model;               
        if (oldValue !== value)
        {
        	model_internal::_dminternal_model = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "_model", oldValue, model_internal::_dminternal_model));
        }     
    }      

    /**
     * methods
     */  


    /**
     *  services
     */                  
     private var _managingService:com.adobe.fiber.services.IFiberManagingService;
    
     public function set managingService(managingService:com.adobe.fiber.services.IFiberManagingService):void
     {
         _managingService = managingService;
     }                      
     
    model_internal function set invalidConstraints_der(value:Array) : void
    {  
     	var oldValue:Array = model_internal::_invalidConstraints;
     	// avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_invalidConstraints = value;   
			_model.model_internal::fireChangeEvent("invalidConstraints", oldValue, model_internal::_invalidConstraints);   
        }     	             
    }             
    
     model_internal function set validationFailureMessages_der(value:Array) : void
    {  
     	var oldValue:Array = model_internal::_validationFailureMessages;
     	// avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_validationFailureMessages = value;   
			_model.model_internal::fireChangeEvent("validationFailureMessages", oldValue, model_internal::_validationFailureMessages);   
        }     	             
    }        
     
     // Individual isAvailable functions     
	// fields, getters, and setters for primitive representations of complex id properties

}

}
