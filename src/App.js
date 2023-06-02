import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ListProductComponent from './components/ListProductComponet';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateProductComponent from './components/CreateProductComponent';
import ViewProductComponent from './components/ViewProductComponet';
import UpdateProductComponent from './components/UpdateProductComponent';
function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route path="/" element={<ListProductComponent />} />
            <Route path="/products" element={<ListProductComponent />} />
            <Route path="/add-product/:id" element={<CreateProductComponent />} />
            <Route path="/view-product/:id" element={<ViewProductComponent />} />
            <Route path="/update-product/:id" element={<UpdateProductComponent />} />
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}
export default App;
