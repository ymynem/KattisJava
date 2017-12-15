/*
Uppgift 0.6 skapa en uintUIntVector.
*/

#include <iostream>
#include <stdexcept>
#include <initializer_list>
using namespace std;

class UIntVector{
	public:
		// size variabel med en uint typ som maximerar värdet.
		size_t _size;
		unsigned int * array;

		//It should be possible to create an empty UIntUIntVector, having zero (0) elements. 
		UIntVector(){
			//std::cout << "default-constructor with size 0" << std::endl;
			_size = 0;
			array = new unsigned int[0];
		}

		//En default constructor som tar size och ska skapa en UIntVector
		explicit UIntVector(size_t value){
			//std::cout << "default-constructor with size" << std::endl;
			this->_size = value;
			array = new unsigned int[this->_size]();
		}

		//En default constructor som tar lista ? 
		UIntVector(initializer_list<unsigned int> lista) {
			//std::cout << "default-constructor with list" << lista.size() << std::endl;
			_size = lista.size();
			array = new unsigned int[_size];

			//kopiera alla element till min lista.
			unsigned int const * elem = lista.begin();
			for(unsigned int i = 0; i< lista.size(); ++i){
				array[i] = *elem;
				elem++;
			}

		}
		
		//En copy contructor
		UIntVector(UIntVector const& lista) {
			//std::cout << "copy-constructor" << std::endl;
			// ska ta en uintUIntVector och kopiera allt i den.
			_size = lista.size();
			array = new unsigned int[_size];
			for(unsigned int i = 0; i < lista.size(); ++i){
				array[i] = lista[i];
			}
		}

		//En move constructor, den ska flytta i minnet.
		UIntVector(UIntVector&& lista){
			//std::cout<< "move construtctor" << std::endl;
			array = lista.array;
			_size = lista._size;
			lista.array = nullptr;
			lista._size = 0;
		}

		~UIntVector() {
			//std::cout << "destructor" << std::endl;
			//nollställ size
			_size = 0;
			//deallokera minne för pekare för att undvika minnesläckor.
			delete[] array;
		}

		//Att kunna accessa element i en vektor
		// The first element of the container shall be at index 0.
		// An exception of type std::out_of_range shall be thrown if a user tries to access an index out-of-bounds.
		unsigned int& operator[](size_t index){
			if(index >= _size){
				throw out_of_range ("index");
			} else{
				unsigned int& value = array[index];
				return value;
			}
		
		}
		
		//Att även kunna accessa const vektor
		// The first element of the container shall be at index 0.
		// An exception of type std::out_of_range shall be thrown if a user tries to access an index out-of-bounds.
		unsigned int const & operator[](size_t index)const {
			if(index >= _size){
				throw out_of_range ("index");
			} else {
				unsigned int const & value = array[index];
				return value;
			}
			
		}

		//copy assignement
		UIntVector& operator= (UIntVector const& lista) {
			//std::cout << "the assignment operator" << std::endl;
			if(lista.array != array){
				delete[] array;
				_size = lista.size();
				array = new unsigned int[_size];
				for(unsigned int i = 0; i < lista.size(); ++i){
					array[i] = lista[i];
				}

			}
			return *this;
		}

		//move assignement
		UIntVector& operator=(UIntVector&& lista){
			//std::cout << "the assignment operator not const" << std::endl;
			if(lista.array != array){
				delete[] array;
				array = lista.array;
				_size = lista._size;
				lista.array = nullptr;
				lista._size = 0;
			}
			return *this;
		}

	
		//Assigns (unsigned int){} to each element in the container.
		//Sätt värdet 0 till allt i arrayen.
		void reset(){
			for(unsigned int i = 0; i < _size; ++i){
				array[i] = 0;
			}

		}
		
		//Returns the size of the container.
		size_t size(){
			return _size;
		}

		//Returns the size of the container.
		size_t size() const{
			return _size;
		}

		void toString()const{
			cout<< "[" ;
			for(int i = 0; i < _size; ++i ){
				cout << array[i] << " " ;
			}
			cout<< "]" << endl;

		}
};