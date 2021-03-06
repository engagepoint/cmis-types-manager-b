Meta:

Narrative:
As a user
I want to Create types with attributes and metadata,
Create subtypes for this type,
Delete this type with subtypes.

Scenario: authentification scenario
When the user opens the default page
When the user fills 'loginForm-login' field with 'test'
When the user fills 'loginForm-password' field with 'test'
When the user fills 'loginForm-URL' field with 'chemistry-opencmis-server-inmemory/atom11' using baseUrl
When clicks on element with id/name/className 'loginBut'
Then wait for '2' sec
Then wait for element 'treeForm' is visible

Scenario: create type with metadata scenario
When clicks on element with id/name/className 'treeForm-tree-0-nodeText'
When clicks on element with id/name/className 'create'
Then wait for element 'createTypeForm' is visible
When the user fills 'inputTextView' field with 'rel1'
When the user fills 'inputTextView1' field with 'rel1'
When the user fills 'inputTextView2' field with 'rel1'
When the user fills 'inputTextView3' field with 'rel1'
When the user fills 'inputTextView4' field with 'rel1'
When the user fills 'inputTextView5' field with 'rel1'
When make 'selectCheckboxFileable' checked
When make 'selectCheckboxFti' checked
When the user clicks on first element with className 'ui-icon-triangle-1-e' with text 'Metadata'
When the user clicks on element with id/name/className 'addNewLineMetadataBtn'
When the user fills 'createMetadataModalForm-newMetaDataId' field with 'met1'
When the user fills 'createMetadataModalForm-newMetaDataName' field with 'met1'
When the user fills 'createMetadataModalForm-newMetaDataLocalName' field with 'met1'
When the user fills 'createMetadataModalForm-newMetaDataQueryName' field with 'met1'
When the user fills 'createMetadataModalForm-newMetaDataLocalNamespace' field with 'met1'
When the user fills 'createMetadataModalForm-newMetaDataDescription' field with 'met1'
When make 'selectCheckboxQuarylable' checked
When make 'selectCheckboxOrderable' checked
When make 'selectCheckboxRequeried' checked
When make 'selectCheckboxInheried' checked
When clicks on element with id/name/className 'createMetadataButton'
Then wait for element 'createTypeForm-accordionPanel-metadataTabel_data' is visible
When make 'metadataTabel-0-j_idt29' checked
When the user clicks on element with id/name/className 'selectedMetadataUpdateBtn'
When the user fills 'updateMetadataModalForm-newMetaDataIdUpdate' field with 'met2'
When the user fills 'updateMetadataModalForm-newMetaDataNameUpdate' field with 'met2'
When the user fills 'updateMetadataModalForm-newMetaDataLocalNameUpdate' field with 'met2'
When the user fills 'updateMetadataModalForm-newMetaDataQueryNameUpdate' field with 'met2'
When the user fills 'updateMetadataModalForm-newMetaDataLocalNamespaceUpdate' field with 'met2'
When the user fills 'updateMetadataModalForm-newMetaDataDescriptionUpdate' field with 'met2'
When clicks on element with id/name/className 'updateMetadataModalForm-updateMetadataButton'
Then wait for element 'updateMetadataModalDialog' is not visible
When the user clicks on element with id/name/className 'addNewLineMetadataBtn'
When the user fills 'createMetadataModalForm-newMetaDataId' field with 'met'
When the user fills 'createMetadataModalForm-newMetaDataName' field with 'met'
When the user fills 'createMetadataModalForm-newMetaDataLocalName' field with 'met'
When the user fills 'createMetadataModalForm-newMetaDataQueryName' field with 'met'
When clicks on element with id/name/className 'createMetadataButton'
Then wait for element 'createTypeForm-accordionPanel-metadataTabel_data' is visible
When make 'metadataTabel-1-j_idt29' unchecked
When the user clicks on element with id/name/className 'selectedMetadataDeleteBtn'
When the user clicks on element with id/name/className 'createTypeBtm'
Then wait for element 'treeForm' is visible
When clicks on element by '//span[@class="ui-tree-toggler ui-icon ui-icon-triangle-1-e"]'
Then element with '//span[@id='treeForm-tree-0_1-nodeText']' has text 'rel1'

Scenario: create subtype 1 scenario
When clicks on element by '//span[@class="ui-tree-toggler ui-icon ui-icon-triangle-1-e"]'
When the user clicks on element with id/name/className 'treeForm-tree-0-nodeText'
When the user clicks on element with id/name/className 'treeForm-tree-0_1-nodeText'
When clicks on element with id/name/className 'commandForm-create'
Then wait for element 'createTypeForm' is visible
When the user fills 'inputTextView' field with 'rel11'
When the user fills 'inputTextView1' field with 'rel11'
When the user fills 'inputTextView2' field with 'rel11'
When the user fills 'inputTextView3' field with 'rel11'
When the user fills 'inputTextView4' field with 'rel11'
When the user fills 'inputTextView5' field with 'rel11'
When clicks on element with id/name/className 'createTypeBtm'
Then wait for element 'treeForm' is visible
When clicks on element by '//span[@class="ui-tree-toggler ui-icon ui-icon-triangle-1-e"]'
When clicks on element by '//span[@class="ui-tree-toggler ui-icon ui-icon-triangle-1-e"]'
Then element with '//span[@id='treeForm-tree-0_1_0-nodeText']' has text 'rel11'

Scenario: create subtype 2 scenario
When the user clicks on element with id/name/className 'treeForm-tree-0-nodeText'
When the user clicks on element with id/name/className 'treeForm-tree-0_1-nodeText'
When clicks on element with id/name/className 'commandForm-create'
Then wait for element 'createTypeForm' is visible
When the user fills 'inputTextView' field with 'rel12'
When the user fills 'inputTextView1' field with 'rel12'
When the user fills 'inputTextView2' field with 'rel12'
When the user fills 'inputTextView3' field with 'rel12'
When the user fills 'inputTextView4' field with 'rel12'
When the user fills 'inputTextView5' field with 'rel12'
When clicks on element with id/name/className 'createTypeBtm'
Then wait for element 'treeForm' is visible
When clicks on element by '//span[@class="ui-tree-toggler ui-icon ui-icon-triangle-1-e"]'
When clicks on element by '//span[@class="ui-tree-toggler ui-icon ui-icon-triangle-1-e"]'
Then element with '//span[@id='treeForm-tree-0_1_1-nodeText']' has text 'rel12'

Scenario: delete type scenario
When clicks on element by '//span[@class="ui-tree-toggler ui-icon ui-icon-triangle-1-e"]'
When the user clicks on element with id/name/className 'treeForm-tree-0-nodeText'
When the user clicks on element with id/name/className 'treeForm-tree-0_1-nodeText'
When the user clicks on element with id/name/className 'commandForm-deleteButton'
Then wait for element 'deleteTypeDialog' is visible
When the user clicks on element with id/name/className 'deleteForm-Yes'
Then wait for element 'treeForm' is visible

Scenario: logout scenario
When clicks on element with id/name/className 'logoutForm-logoutBtn'
Then wait for element 'loginForm' is visible