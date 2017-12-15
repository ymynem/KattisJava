/*
Uppgift 0.7 skapa en uintVector.
*/

#include <iostream>
#include <stdexcept>
#include <initializer_list>
//#include <algorithm>

using namespace std;

template <class T> class Vector{

	public:
		static_assert(std::is_move_constructible<T>::value, "move constructible not working");
		static_assert(std::is_move_assignable<T>::value, "move assigneble not working");
		size_t _size;// size variabel med en uint typ som maximerar värdet.
		T * array;
		size_t _capacity;
		typedef T * It;
		typedef T const * const_it;

		
		//It should be possible to create an empty UIntVector, having zero (0) elements. 
		Vector(){
			_size = 0;
			array = new T[0];
			_capacity = _size;
		}

		//En default constructor som tar size och ska skapa en Vector
		explicit Vector(size_t const value){
			this->_size = value;
			_capacity = _size;
			array = new T[this->_size]();
		}

		explicit Vector(size_t value, T init){
			this->_size = value;
			_capacity = _size;
			array = new T[this->_size]();
			for(size_t i = 0; i < _size; ++i){
				array[i] = init;
			}
		}
		//En default constructor som tar lista ? 
		Vector(initializer_list<T> lista) {
			_size = lista.size();
			_capacity =_size;
			array = new T[_size];

			//kopiera alla element till min lista.
			T const * elem = lista.begin();
			for(size_t i = 0; i< lista.size(); ++i){
				array[i] = *elem;
				elem++;
			}

		}

		//En copy contructor
		Vector(Vector const& lista) {
			// ska ta en uintVector och kopiera allt i den.
			_size = lista.size();
			_capacity = _size;
			array = new T[_size];
			for(size_t i = 0; i < lista.size(); ++i){
				array[i] = lista[i];
			}
		}

		//En move constructor, den ska flytta i minnet.
		Vector(Vector&& lista){
			
			//std::cout<< "move construtctor" << std::endl;
			array = lista.array;
			_size = lista._size;
			_capacity = _size;
			lista.array = nullptr;
			lista._size = 0;
		}

		~Vector() {
			//nollställ size
			_size = 0;
			_capacity = _size;
			//deallokera minne för pekare för att undvika minnesläckor.
			delete[] array;
		}

		//Att kunna accessa element i en vektor
		// The first element of the container shall be at index 0.
		// An exception of type std::out_of_range shall be thrown if a user tries to access an index out-of-bounds.
		T& operator[](size_t index){
			if(index >= _size){
				throw out_of_range ("index");
			} else{
				T& value = array[index];
				return value;
			}
		
		}
		
		//Att även kunna accessa const vektor
		// The first element of the container shall be at index 0.
		// An exception of type std::out_of_range shall be thrown if a user tries to access an index out-of-bounds.
		const T& operator[](size_t index) const {
			if(index >= _size){
				throw out_of_range ("index");
			} else {
				T const & value = array[index];
				return value;
			}
			
		}

		//copy assignement
		Vector& operator = (Vector const& lista) {
			//std::cout << "the assignment operator" << std::endl;
			if(lista.array != array){
				delete[] array;
				_size = lista.size();
				_capacity = _size;
				array = new T[_size];
				for(size_t i = 0; i < lista.size(); ++i){
					array[i] = lista[i];
				}
			}
			return *this;
		}

		//move assignement
		Vector& operator=(Vector&& lista){
			//std::cout << "the assignment operator not const" << std::endl;
			if(lista.array != array){
				delete[] array;
				array = lista.array;
				_size = lista._size;
				_capacity = _size;
				lista.array = nullptr;
				lista._size = 0;
			}
			return *this;
		}

		/*
		Appends the given element value to the end of the
		container with amortized constant time complexity,
		meaning that insertions are constant in most
		cases
		*/
		void push_back(T t){
			if(_size == _capacity){
				T *tmp = reallocate(t);
				delete_pointer(tmp);
				increase__size();
			}  else if( _size < _capacity){
				array[_size] = t;
				increase__size();
			} 
		}

		/*
		Inserts the element value immediately before
		the index specified. If index == size(), see
		push_back. If the index is out-of-bounds; throw
		a std::out_of_range
		*/
		void insert(size_t index, T t){
			if(index > _size || index < 0){
				throw out_of_range ("Woops! out-of-bounds");
			} 
			else if(index == _size){
				push_back(t);
			} 
			else if(_capacity == _size){
				T* tmp = reallocate(t);
				move_back(tmp, index, t);
				delete_pointer(tmp);
				increase__size();
			} else if(_size < _capacity){
				move_back(array,index, t);
				increase__size();
			} 
		}


		/*
		Removes every element, effectively making
		size() == 0.
		*/
		void clear(){
			_size = 0;
		}

		/*
		Removess the element at the index specified.
		*/
		void erase(size_t index){
			if(index >= _size || index < 0){
				throw out_of_range("out of range");
			}else{
				//array[index] = array[size()-1];
				for(size_t i = index; i < _size-1 ; ++i){
					array[i] = array[i+1];
				}
				if(size() > 0){
				_size -= 1;
				}
			} 
		}

		/*
		Returns the number of elements that can
		potentially be storerd in the cointainter without
		having to reallocate the underlying storage.
		*/
		size_t capacity() const {
			return _capacity;
		}

		/*
		Returns the number of elements in the container.
		*/
		size_t size() const {
			return _size;
		}
		size_t size(){
			return _size;
		}

		/*
		Returns a RandomAccessIterator to the first
		element of the range.
		*/
		//T const * const 
		const_it begin() const{
			T* const tmp= array;
			return tmp;
		}
		/*
		Returns a RandomAccessIterator to the first
		element of the range.
		*/
		//T *
		It begin(){
			return array;
		}
		/*
		Returns a RandomAccessIterator referring to the
		element right after the last element in the
		container.
		*/
		//T const * const 
		const_it end() const{
			T* const tmp= array+size();
			return tmp;
		}
		/*
		Returns a RandomAccessIterator referring to the
		element right after the last element in the
		container.
		*/
		//T * 
		It end(){
			return array + size();
		}
		/*
		Returns a RandomAccessIterator referring to the
		first element that compares equal to the argument,
		or end() if no such element is found.
		*/
		const_it find(T const& t) const{
			for (size_t i = 0; i < _size; ++i){
				if(t == array[i]){
					T* const tmp= array+i;
					return tmp;
				}
			}
			return end();
		}
		It find(T const& t){
			for (size_t i = 0; i < _size; ++i){
				if(t == array[i]){
					T* const tmp= array+i;
					return tmp;
				}
			}
			return end();
		}
		//Assigns (T){} to each element in the container.
		//Sätt värdet 0 till allt i arrayen.
		void reset(){
			for(size_t i = 0; i < _size; ++i){
				array[i] = {};
			}

		}
		//Skriver ut objekt.
		void toString()const{
			cout<< "[ ";
			for(size_t i = 0; i < _size; ++i ){
				cout << array[i] << " " ;
			}
			cout<< "]" << endl;

		}

		private:
			T* reallocate(T t){
				_capacity += (_capacity+1)*100;
				T *tmp = new T[_capacity]; // allokera minnesplats för den temporära arrayen
				for(size_t i = 0; i < _size; ++i){
					tmp[i] = array[i];
				} 
				tmp[_size] = t;
				return tmp;
			}

			void delete_pointer(T* tmp){
				delete [] array; // ta bort gamla
				array = tmp;  // skriv över med nya arrayen.
				//delete[] tmp;

			}
			void increase__size(){
				++_size;
			}
			void move_back(T* & tmp, size_t index, T& t){
				for(size_t i = _size; i > index ; --i){
					tmp[i] = tmp[i-1];
				} 
				tmp[index] = t;
			}
			
			
			/*void sort(bool descending){
				if(!descending){
					std::sort(begin(), end(), greater<T>());
				}else {
					std::sort(begin(), end());
				}
		}*/
		
};