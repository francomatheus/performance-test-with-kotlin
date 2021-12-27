import pymongo
import random

def connection_database():
    myclient = pymongo.MongoClient("mongodb://localhost:27017/")
    mydb = myclient["core"]
    return mydb["user"]
    
def insert_many(collection, documents):
    collection.insert_many(documents, ordered=False)

col = connection_database()

name = ["Formiga", "Cachorro", "Papagaio", "Girafa", "Sapo", "Gato", "Abelha", "Vaca", "Elefante", "Bufalo", "Peixe", "Tubarão", "Arara", "Caranguejo", "Calopsita", "Pombo", "Galinha", "Pato", "Cobra", "Porco"]

profissao = ["Advogado", "Tatuador", "Medico", "Enfermeiro", "Professor", "Autonomo"]

for i in range(0,20):
    prof = random.choice(profissao)
    documents = []
    for j in range(0,25000):
        data={"salary":i+j}
        element = {"id":i, "name":name[i], "profissão":prof, "data": data}
        documents.append(element)
    insert_many(col, documents)
