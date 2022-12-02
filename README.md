# login-registration-product

This is a demo project which contains:
-Registration
-Log in
-CRUD of a product type

Endpoints for registration:
<ul>
<li>Post  /api/product</li>
<li>-> API request example</li>
<li>    "name": "string",</li>
<li>    "username": "string",</li>
<li>    "email": "string@string.com",</li>
<li>    "password": "string",</li>
<li>    "userRole": "USER"</li>
</brake>    
<li>Returns a token for the user activation </li>

<li>Then call the endpoint to activate the user </li>
<li>Get: /api/registration/confirm?token="token that should be returned"</li>
</ul>
Endpoint for product:
<ul>
<li> create one ore multiple products</li>
<li> Post: api/product</li>
<li>  [</li>
<li>     {</li>
<li>         "productId": "12",</li>
<li>         "productName": "productName",</li>
<li>         "price": "19.22",</li>
<li>         "productType": "OTHER",</li>
<li>         "isAvailable": "true"</li>
<li>     }</li>
<li> ]</li>
<li> Put: api/product to update product</li>

<li> Get: api/product/productId to return one product</li>

<li> Get: api/product/all returns all product </li>

<li> Delete: api/product/productId deletes a specific product</li>
</ul>
