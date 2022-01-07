import pymongo
import random

def connection_database():
    myclient = pymongo.MongoClient("mongodb://root:example@localhost:27017/core?authSource=admin")["core"]["user"]
#     mydb = myclient["core"]
    return myclient
    
def insert_many_documents(collection, documents):
    collection.insert_many(documents, ordered=False)

col = connection_database()

name = ["Formiga", "Cachorro", "Papagaio", "Girafa", "Sapo", "Gato", "Abelha", "Vaca", "Elefante", "Bufalo", "Peixe", "Tubarão", "Arara", "Caranguejo", "Calopsita", "Pombo", "Galinha", "Pato", "Cobra", "Porco"]

profissao = ["Advogado", "Tatuador", "Medico", "Enfermeiro", "Professor", "Autonomo"]

for i in range(0,20):
    prof = random.choice(profissao)
    documents = []
    for j in range(0,500):
        print(f"Inserindo code: {i}, numero: {j}")
        if j % 2 == 0:
            data = {"transaction":i+j}
            element = {"code":i, "name":name[i], "profissao":prof, "type":"ExampleA", "data": data}
        else:
            data = {"statement":i+j, "other":"Fix"}
            element = {"code":i, "name":name[i], "profissao":prof, "type":"ExampleB", "data": data}

        documents.append(element)
    insert_many_documents(col, documents)
