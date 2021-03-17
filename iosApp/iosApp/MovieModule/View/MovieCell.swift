//
//  MovieCell.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import Kingfisher

struct MovieCell: View {
    
    private let viewModel: MovieViewModelProtocol
    var tapSaveButton: ((MovieViewModelProtocol) -> Void)?
    @State private var isFavorite: Bool = false
    
    init(viewModel: MovieViewModelProtocol,
         tapSaveButton: ((MovieViewModelProtocol) -> Void)? = nil) {
        self.viewModel = viewModel
        self.tapSaveButton = tapSaveButton
        _isFavorite = State(initialValue: viewModel.isFavorite)
    }
    
    var body: some View {
        GeometryReader { reader in
            VStack(spacing: 0) {
                KFImage(viewModel.imageURL)
                    .fade(duration: 0.25)
                    .resizable()
                
                HStack {
                    Text(viewModel.title)
                        .foregroundColor(.white)
                    
                    Spacer()
                    
                    Button(action: {
                        isFavorite.toggle()
                        tapSaveButton?(viewModel)
                    }, label: {
                        Image(systemName: "heart.fill")
                            .resizable()
                            .foregroundColor(isFavorite ? .yellow : .white)
                            .frame(width: 20, height: 20, alignment: .trailing)
                    })
                }
                .padding(.all, 8)
                .frame(height: reader.size.height * 0.2)
                .frame(maxWidth: .infinity)
                .background(Color.blue)
            }
        }
    }

}

struct MovieCell_Previews: PreviewProvider {
        
    static var previews: some View {
        MovieCell(viewModel: MovieViewModelPreview())
            .previewLayout(.fixed(width: 120, height: 220))
    }
}
