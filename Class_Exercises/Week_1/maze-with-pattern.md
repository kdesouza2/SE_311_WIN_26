<!-- Week 1 In Class Exercise -->

```plantuml

scale 7
skinparam ArrowThickness 3
skinparam classBorderThickness 3



@startuml maze-with-pattern 

' Classes
class MapSite {
  +Enter()
} 

class Door {
  -isOpen 
  -room1 
  -room2
  +Enter()
}

class Room {
  -roomNumber
  +Enter()
  +GetSide()
  +SetSide()
}

class Maze {
  -roomNumber
  +AddRoom()
  +RoomNo(): Room
}

class Wall {
  +Enter()
}

class MazeFactory {
  +makeMaze(): Maze
  +makeWall(): Wall
  +makeRoom(): Room
  +makeDoor(): Door
}

class MazeGameCreator {
    +createMaze(Factory: MazeFactory): Maze
}

class SpellDoor #line:pink{
}

class BombedDoor #line:green{
}

class BombedWall #line:green{
}

class EnchantedWall #line:pink{
}

class BombedRoom #line:green{
}

class EnchantedRoom #line:pink{
}

class EnchantedMazeFactory #line:pink{
    +makeMaze(): Maze
    +makeRoom(): Room
    +makeDoor(): Door
    +makeWall(): Wall
}

class BombedMazeFactory #line:green{
    +makeMaze(): Maze
    +makeRoom(): Room
    +makeDoor(): Door
    +makeWall(): Wall
}


' Relationships
Door --|> MapSite 
Room --|> MapSite
Wall --|> MapSite
BombedRoom --|> Room #green
BombedWall --|> Wall #green
BombedDoor --|> Door #green
SpellDoor --|> Door #pink
EnchantedWall --|> Wall #pink
EnchantedRoom --|> Room #pink
EnchantedMazeFactory --|> MazeFactory
BombedMazeFactory --|> MazeFactory
Room o-- MapSite
Maze o-- Room
Maze *-- Room
MazeFactory ..> Maze #orange
MazeFactory ..> Room #orange
MazeFactory ..> Door #orange
MazeFactory ..> Wall #orange
MazeGameCreator ..> MazeFactory
MazeGameCreator ..> BombedMazeFactory
MazeGameCreator ..> EnchantedMazeFactory
EnchantedMazeFactory ..> Maze
BombedMazeFactory ..> Maze
EnchantedMazeFactory ..> SpellDoor
EnchantedMazeFactory ..> EnchantedWall
EnchantedMazeFactory ..> EnchantedRoom
BombedMazeFactory ..> BombedDoor
BombedMazeFactory ..> BombedWall
BombedMazeFactory ..> BombedRoom

@enduml