/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - Department.as.
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
public class _Super_Department extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void 
    {
        try 
        {
            if (flash.net.getClassByAlias("services.Department") == null)
            {
                flash.net.registerClassAlias("services.Department", cz);
            } 
        }
        catch (e:Error) 
        {
            flash.net.registerClassAlias("services.Department", cz); 
        }
    }   
     
    model_internal static function initRemoteClassAliasAllRelated() : void 
    {
    }

	model_internal var _dminternal_model : _DepartmentEntityMetadata;

	/**
	 * properties
	 */
	private var _internal_businessunit : String;
	private var _internal_budget : String;
	private var _internal_manager : String;
	private var _internal_locationstate : String;
	private var _internal_locationcity : String;
	private var _internal_locationstreet : String;
	private var _internal_actualcontractors : Object;
	private var _internal_actualsalary : String;
	private var _internal_esttravel : String;
	private var _internal_estcontractors : String;
	private var _internal_actualexpenses : String;
	private var _internal_hrrep : String;
	private var _internal_locationzipcode : String;
	private var _internal_id : int;
	private var _internal_estsalary : String;
	private var _internal_actualsupplies : String;
	private var _internal_name : String;
	private var _internal_costcenter : int;
	private var _internal_actualtravel : String;
	private var _internal_estsupplies : String;

    private static var emptyArray:Array = new Array();

    /**
     * derived property cache initialization
     */  
    model_internal var _cacheInitialized_isValid:Boolean = false;   
    
	model_internal var _changeWatcherArray:Array = new Array();   

	public function _Super_Department() 
	{	
		_model = new _DepartmentEntityMetadata(this);
	
		// Bind to own data properties for cache invalidation triggering  
       
	}

    /**
     * data property getters
     */
	[Bindable(event="propertyChange")] 
    public function get businessunit() : String    
    {
            return _internal_businessunit;
    }    
	[Bindable(event="propertyChange")] 
    public function get budget() : String    
    {
            return _internal_budget;
    }    
	[Bindable(event="propertyChange")] 
    public function get manager() : String    
    {
            return _internal_manager;
    }    
	[Bindable(event="propertyChange")] 
    public function get locationstate() : String    
    {
            return _internal_locationstate;
    }    
	[Bindable(event="propertyChange")] 
    public function get locationcity() : String    
    {
            return _internal_locationcity;
    }    
	[Bindable(event="propertyChange")] 
    public function get locationstreet() : String    
    {
            return _internal_locationstreet;
    }    
	[Bindable(event="propertyChange")] 
    public function get actualcontractors() : Object    
    {
            return _internal_actualcontractors;
    }    
	[Bindable(event="propertyChange")] 
    public function get actualsalary() : String    
    {
            return _internal_actualsalary;
    }    
	[Bindable(event="propertyChange")] 
    public function get esttravel() : String    
    {
            return _internal_esttravel;
    }    
	[Bindable(event="propertyChange")] 
    public function get estcontractors() : String    
    {
            return _internal_estcontractors;
    }    
	[Bindable(event="propertyChange")] 
    public function get actualexpenses() : String    
    {
            return _internal_actualexpenses;
    }    
	[Bindable(event="propertyChange")] 
    public function get hrrep() : String    
    {
            return _internal_hrrep;
    }    
	[Bindable(event="propertyChange")] 
    public function get locationzipcode() : String    
    {
            return _internal_locationzipcode;
    }    
	[Bindable(event="propertyChange")] 
    public function get id() : int    
    {
            return _internal_id;
    }    
	[Bindable(event="propertyChange")] 
    public function get estsalary() : String    
    {
            return _internal_estsalary;
    }    
	[Bindable(event="propertyChange")] 
    public function get actualsupplies() : String    
    {
            return _internal_actualsupplies;
    }    
	[Bindable(event="propertyChange")] 
    public function get name() : String    
    {
            return _internal_name;
    }    
	[Bindable(event="propertyChange")] 
    public function get costcenter() : int    
    {
            return _internal_costcenter;
    }    
	[Bindable(event="propertyChange")] 
    public function get actualtravel() : String    
    {
            return _internal_actualtravel;
    }    
	[Bindable(event="propertyChange")] 
    public function get estsupplies() : String    
    {
            return _internal_estsupplies;
    }    

    /**
     * data property setters
     */      
    public function set businessunit(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_businessunit == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_businessunit;               
        if (oldValue !== value)
        {
            _internal_businessunit = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "businessunit", oldValue, _internal_businessunit));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set budget(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_budget == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_budget;               
        if (oldValue !== value)
        {
            _internal_budget = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "budget", oldValue, _internal_budget));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set manager(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_manager == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_manager;               
        if (oldValue !== value)
        {
            _internal_manager = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "manager", oldValue, _internal_manager));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set locationstate(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_locationstate == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_locationstate;               
        if (oldValue !== value)
        {
            _internal_locationstate = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "locationstate", oldValue, _internal_locationstate));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set locationcity(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_locationcity == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_locationcity;               
        if (oldValue !== value)
        {
            _internal_locationcity = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "locationcity", oldValue, _internal_locationcity));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set locationstreet(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_locationstreet == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_locationstreet;               
        if (oldValue !== value)
        {
            _internal_locationstreet = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "locationstreet", oldValue, _internal_locationstreet));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set actualcontractors(value:Object) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_actualcontractors == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:Object = _internal_actualcontractors;               
        if (oldValue !== value)
        {
            _internal_actualcontractors = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "actualcontractors", oldValue, _internal_actualcontractors));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set actualsalary(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_actualsalary == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_actualsalary;               
        if (oldValue !== value)
        {
            _internal_actualsalary = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "actualsalary", oldValue, _internal_actualsalary));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set esttravel(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_esttravel == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_esttravel;               
        if (oldValue !== value)
        {
            _internal_esttravel = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "esttravel", oldValue, _internal_esttravel));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set estcontractors(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_estcontractors == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_estcontractors;               
        if (oldValue !== value)
        {
            _internal_estcontractors = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "estcontractors", oldValue, _internal_estcontractors));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set actualexpenses(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_actualexpenses == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_actualexpenses;               
        if (oldValue !== value)
        {
            _internal_actualexpenses = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "actualexpenses", oldValue, _internal_actualexpenses));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set hrrep(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_hrrep == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_hrrep;               
        if (oldValue !== value)
        {
            _internal_hrrep = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "hrrep", oldValue, _internal_hrrep));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set locationzipcode(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_locationzipcode == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_locationzipcode;               
        if (oldValue !== value)
        {
            _internal_locationzipcode = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "locationzipcode", oldValue, _internal_locationzipcode));
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
    public function set estsalary(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_estsalary == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_estsalary;               
        if (oldValue !== value)
        {
            _internal_estsalary = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "estsalary", oldValue, _internal_estsalary));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set actualsupplies(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_actualsupplies == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_actualsupplies;               
        if (oldValue !== value)
        {
            _internal_actualsupplies = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "actualsupplies", oldValue, _internal_actualsupplies));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set name(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_name == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_name;               
        if (oldValue !== value)
        {
            _internal_name = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "name", oldValue, _internal_name));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set costcenter(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_costcenter;               
        if (oldValue !== value)
        {
            _internal_costcenter = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "costcenter", oldValue, _internal_costcenter));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set actualtravel(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_actualtravel == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_actualtravel;               
        if (oldValue !== value)
        {
            _internal_actualtravel = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "actualtravel", oldValue, _internal_actualtravel));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set estsupplies(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_estsupplies == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_estsupplies;               
        if (oldValue !== value)
        {
            _internal_estsupplies = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "estsupplies", oldValue, _internal_estsupplies));
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

		if (_model.isBusinessunitAvailable && _internal_businessunit == null)
		{
			violatedConsts.push("businessunitIsRequired");
			validationFailureMessages.push("businessunit is required");
		}
		if (_model.isBudgetAvailable && _internal_budget == null)
		{
			violatedConsts.push("budgetIsRequired");
			validationFailureMessages.push("budget is required");
		}
		if (_model.isManagerAvailable && _internal_manager == null)
		{
			violatedConsts.push("managerIsRequired");
			validationFailureMessages.push("manager is required");
		}
		if (_model.isLocationstateAvailable && _internal_locationstate == null)
		{
			violatedConsts.push("locationstateIsRequired");
			validationFailureMessages.push("locationstate is required");
		}
		if (_model.isLocationcityAvailable && _internal_locationcity == null)
		{
			violatedConsts.push("locationcityIsRequired");
			validationFailureMessages.push("locationcity is required");
		}
		if (_model.isLocationstreetAvailable && _internal_locationstreet == null)
		{
			violatedConsts.push("locationstreetIsRequired");
			validationFailureMessages.push("locationstreet is required");
		}
		if (_model.isActualcontractorsAvailable && _internal_actualcontractors == null)
		{
			violatedConsts.push("actualcontractorsIsRequired");
			validationFailureMessages.push("actualcontractors is required");
		}
		if (_model.isActualsalaryAvailable && _internal_actualsalary == null)
		{
			violatedConsts.push("actualsalaryIsRequired");
			validationFailureMessages.push("actualsalary is required");
		}
		if (_model.isEsttravelAvailable && _internal_esttravel == null)
		{
			violatedConsts.push("esttravelIsRequired");
			validationFailureMessages.push("esttravel is required");
		}
		if (_model.isEstcontractorsAvailable && _internal_estcontractors == null)
		{
			violatedConsts.push("estcontractorsIsRequired");
			validationFailureMessages.push("estcontractors is required");
		}
		if (_model.isActualexpensesAvailable && _internal_actualexpenses == null)
		{
			violatedConsts.push("actualexpensesIsRequired");
			validationFailureMessages.push("actualexpenses is required");
		}
		if (_model.isHrrepAvailable && _internal_hrrep == null)
		{
			violatedConsts.push("hrrepIsRequired");
			validationFailureMessages.push("hrrep is required");
		}
		if (_model.isLocationzipcodeAvailable && _internal_locationzipcode == null)
		{
			violatedConsts.push("locationzipcodeIsRequired");
			validationFailureMessages.push("locationzipcode is required");
		}
		if (_model.isEstsalaryAvailable && _internal_estsalary == null)
		{
			violatedConsts.push("estsalaryIsRequired");
			validationFailureMessages.push("estsalary is required");
		}
		if (_model.isActualsuppliesAvailable && _internal_actualsupplies == null)
		{
			violatedConsts.push("actualsuppliesIsRequired");
			validationFailureMessages.push("actualsupplies is required");
		}
		if (_model.isNameAvailable && _internal_name == null)
		{
			violatedConsts.push("nameIsRequired");
			validationFailureMessages.push("name is required");
		}
		if (_model.isActualtravelAvailable && _internal_actualtravel == null)
		{
			violatedConsts.push("actualtravelIsRequired");
			validationFailureMessages.push("actualtravel is required");
		}
		if (_model.isEstsuppliesAvailable && _internal_estsupplies == null)
		{
			violatedConsts.push("estsuppliesIsRequired");
			validationFailureMessages.push("estsupplies is required");
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
    public function get _model() : _DepartmentEntityMetadata
    {
		return model_internal::_dminternal_model;              
    }	
    
    public function set _model(value : _DepartmentEntityMetadata) : void       
    {
    	var oldValue : _DepartmentEntityMetadata = model_internal::_dminternal_model;               
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
