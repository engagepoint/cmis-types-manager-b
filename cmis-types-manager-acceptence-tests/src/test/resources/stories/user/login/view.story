Meta:

Narrative:
As a user
I want to perform log in
So that I can log in and see tree table

Scenario: authentification scenario
When the user opens the default page
When the user fills 'loginForm-login' field with 'test'
When the user fills 'loginForm-password' field with 'test'
When the user fills 'loginForm-URL' field with 'http://lab13:8160/chemistry-opencmis-server-inmemory-0.10.0/atom11'
When clicks on element with id/name/className 'loginForm-loginBut'
Then wait for element 'treeForm' is visible
When clicks on element with id/name/className 'view'
Then wait for element 'viewForm' is visible
When clicks on element with id/name/className 'viewForm-return'
Then wait for element 'treeForm' is visible

