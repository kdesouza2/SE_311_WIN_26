```plantuml

@startuml
actor User

User -> InteractInput : enterLine()
InteractInput -> KWICController : acceptInput()

KWICController -> LineStorage : addOneLine(...)
LineStorage --> KWICController : line added

'--- Subject notifies observers ---
KWICController -> KWICSubject : notify(ActionEvent)
KWICSubject -> KWICSubject : iterate listenerList

'--- Observer 1: OutputGUIPanel ---
KWICSubject -> OutputGUIPanel : actionPerformed(e)
OutputGUIPanel -> LineStorage : getAllLines()
LineStorage --> OutputGUIPanel : all lines
OutputGUIPanel -> OutputGUIPanel : displayAllSentences()

'--- Observer 2: KeywordIndexGUIPanel ---
KWICSubject -> KeywordIndexGUIPanel : actionPerformed(e)
KeywordIndexGUIPanel -> LineStorage : getAllLines()
LineStorage --> KeywordIndexGUIPanel : all lines
KeywordIndexGUIPanel -> KeywordIndexGUIPanel : displayIndex()

@enduml
