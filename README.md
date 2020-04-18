# sapient-learning-modules
This repository logs the learning process for the Publicis Sapient Pre-joining modules.

## WEEK-2
Process to create replication of mongodb
```
- mongod --port 27017 --dbpath /var/lib/mongodb --replSet replicationSet

- mkdir /var/lib/mongodb1

- mkdir /var/lib/mongodb2

- mongod --port 27018 --dbpath /var/lib/mongodb1 --replSet replicationSet

- mongod --port 27019 --dbpath /var/lib/mongodb2 --replSet replicationSet
```

### Configuration

- mongodb - 27017 (primary)
- mongodb1 - 27018 (immediate replication)
- mongodb2 - 27019 (delayed replication)

```
- mongo --port 27017 (to run queries in primary node)

- rs.initiate() (for initiating replication set)

- rs.add("localhost:27018");
   
- rs.add("localhost:27019");

- cnf = {_id: 'replicationSet', "protocolVersion" : NumberLong(1), members: [{_id: 0, host: 'localhost:27017'}, 
            {_id: 1, host: 'localhost:27018'}, 
            {_id: 2, host: 'localhost:27019', priority: 0, hidden: true, slaveDelay: 3600}]}


- rs.reconfig(cnf)

- rs.config() (to verify the delay of the node)
```
### Verification:
```
- use daiict
- db.sapient.insertOne({name: "yash" , "title": "ASDE1"})

- mongo --port 27018
- rs.slaveOk() (to allow replication access)
- use daiict
- db.sapient.find()

  
- mongo --port 27019
- rs.slaveOk() (to allow replication access)
- use daiict
- db.sapient.find()
```
