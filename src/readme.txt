//TODO - Make better types, Colors, Fonts, etc.
//Produce .gv file for the Class Hierarchy of this project.
//Graph should be able to have a newEdgeAttributes, newGraphAttributes, newNodeAttributes method
//Add in support to Graph to be able to hold onto all Node(s) as a Set;
//having setters return 'this' for method chaining would be nice--otherwise setting multiple attributes gets very verbose
//You probably want to check for duplicates when calling Graph.addObject(), otherwise you'll end up defining things more than once. I think is ok in the dot language (it just ends up amalgamating the attributes), but you probably want to prevent it. LinkedHashMap might be appropriate here instead of ArrayList, but it probably doesn't matter much.
//Use attribute objects instead of many setters on DotObjects (?)
