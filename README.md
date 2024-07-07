## Features

* Room Database
* Hilt
* ViewModel, read+write
* UI in Compose, list + write (Material3)
* Navigation
* Repository and data source
* Kotlin Coroutines and Flow
* Unit tests
* UI tests using fake data with Hilt


## Architecture Explanation

### Base:

```
arch-template-folder
    |___app (module)
        |___domain 	 
            |___data (optional/ui datamodel)
            |___repository 
            |___local 
                |___db 
                    |___AppDB.kt
                    |___Model.kt (Entity)
                    |___Dao
            |___remote
                |___cache
                |___interceptors
        |___di 
            |___ AppModule.kt etc.
        |___ui 		    
            |___navigation	 
            |___ui state 		     
            |___ viewmodels
            |___usecases 
    |___gradle		     
        |___ wrapper		     
        |___ libs.version.toml
    |___feature_1 		     
        |___ feature_model... 		     
    |___[Other Feature modules]
```


### Modularized: 

```
arch-template-folder	
    |___app (module)		     
        |___navigation		     
        |___ui state		     
        |___ui based viewmodels
    |___core-shared module		     
        |___utils		     
        |___extensions		     
        |___common data model		     
        |___use-cases		     
        |___shared viewmodels		     
        |___repositories		     
        |___api services		     
        |___unit test
    |___core-ui module (if needed)		     
        |___ composable		     
        |___ custom views		     
        |___ ui testing
    |___core-db module		     
        |___ data		     	
        |___ model (Entity)		     
        |___ domain		     	
        |___ model (Entity)		     
        |___ mapper (data-model —> domain-model)		     
        |___ di		     
        |___ local db
    |___gradle		     
        |___ wrapper		     
        |___ libs.version.toml
    |___app_feature_1		     
        |___ feature_model... 		     
    |___[Other Feature modules]
```


## Usage

1. Clone this branch (base version)

```
git clone https://github.com/sam43/arch_template.git --branch arch/base
```
If ```modularized``` template is needed please clone like following:

```
git clone https://github.com/sam43/arch_template.git --branch arch/modularized
```

2. Run the customizer script:

```
./customizer.sh your.package.name DataItemType [MyApplication]
```
For example: ```./customizer.sh com.company.play PlayData PlayApp``` 

Where `your.package.name` is your app ID (should be lowercase) and `DataItemType` is used for the
name of the screen, exposed state and data base entity (should be PascalCase/CamelCase). You can add an optional application name.
