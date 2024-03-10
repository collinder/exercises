class TreeStore:
    dict = {} # Хэш таблица имеет время O(1) в большинстве случаев - пока не начинается hash collision. 
    # В условии данной задачи ничего про большое количество данных не было.
    # В случае больших данных я бы сделал огромный массив указателей для O(1) доступа к элементам по id и дерево, в каждом ноде которого есть указатель на родителя и список указателей на детей. Потому что условие ничего не говорит про память.
    def __init__(self, arr):
        for el in arr:
            self.dict[el["id"]] = {"parent": el["parent"], "type": el["type"] if "type" in el else None, "children": []}
        for el in self.dict.keys(): ## для быстрой операции составления списка детей придется сделать массив детей в каждом ноде. Учитывая, что для сбора детей всё равно надо проходить весь массив, нас не волнует время поиска элемента тут
            if (self.dict[el] != "root"):
                p = self.dict[el]["parent"] 
                if p and p != "root":
                    self.dict[p]["children"].append(el) # Валидации данных нигде не будет, в приоритете производительность. Увы, но таково ТЗ

    def getAll(self): # быстрее пройти по хэш таблице, нежели собирать детей через массив
        collect = []
        for el in self.dict.keys():
            value = self.dict[el]
            if value["parent"] != "root": # честно скажу, это не слишком удобно, когда у самого головного нода нет типа. Теперь мне нужно ввести на это проверку в паре мест. 
                collect.append({"id": el, "parent": value["parent"], "type" : value["type"]})
            else:
                collect.append({"id": el, "parent": value["parent"]})
        return collect

    def getAllParents(self, id):
        collect = []
        parent = self.dict[id]["parent"]
        while True:
            if not parent or parent == "root":
                return collect
            value = self.dict[parent]
            collect.append({"id": parent, "parent": value["parent"], "type" : value["type"]})
            parent = self.dict[parent]["parent"] 

    def getItem(self, id):
        item = self.dict[id]
        if not item["parent"] or item["parent"] == "root": 
            return {"id": id, "parent": self.dict[id]["parent"]} 
        else:
            return {"id": id, "parent": self.dict[id]["parent"], "type" : self.dict[id]["type"]}

    def getChildren(self, id):
        collect = []
        if self.dict[id]["children"]:
            for ch in self.dict[id]["children"]:
                sec_gen = self.getChildren(ch)
                if sec_gen:
                    collect = collect + sec_gen
                collect.append({"id": ch, "parent": self.dict[ch]["parent"], "type" : self.dict[ch]["type"]})
        return collect

    def printALL(self):
        for key in self.dict.keys():
            print(key)
            print(self.dict[key])

items = [
    {"id": 1, "parent": "root"},
    {"id": 2, "parent": 1, "type": "test"},
    {"id": 3, "parent": 1, "type": "test"},
    {"id": 4, "parent": 2, "type": "test"},
    {"id": 5, "parent": 2, "type": "test"},
    {"id": 6, "parent": 2, "type": "test"},
    {"id": 7, "parent": 4, "type": None},
    {"id": 8, "parent": 4, "type": None}
]
ts = TreeStore(items)  
#ts.printALL();
print(ts.getAll())
print(ts.getItem(7))
print(ts.getAllParents(7))
print(ts.getChildren(4))


